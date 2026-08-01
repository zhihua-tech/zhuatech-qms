/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.regex.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc
class QmsApiIntegrationTests {
    @Autowired MockMvc mvc;
    private String login() throws Exception {
        String json=mvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"admin\",\"password\":\"admin123\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.user.role").value("ADMIN"))
                .andReturn().getResponse().getContentAsString();
        Matcher matcher=Pattern.compile("\\\"token\\\":\\\"([^\\\"]+)\\\"").matcher(json);
        if(!matcher.find())throw new AssertionError("登录响应中缺少 token");
        return matcher.group(1);
    }
    @Test void adminCanReadQualityDashboard() throws Exception {
        mvc.perform(get("/api/qms/dashboard").header("Authorization","Bearer "+login()))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.pendingInspection").isNumber())
                .andExpect(jsonPath("$.data.failedLots").value(1)).andExpect(jsonPath("$.data.openNc").value(3));
    }
    @Test void adminCanCreateInspectionLot() throws Exception {
        String body="{\"materialCode\":\"MAT-TEST-01\",\"materialName\":\"测试物料\",\"sourceType\":\"来料检验\",\"sourceRef\":\"GRN-TEST\",\"supplierName\":\"示例供应商\",\"batchQty\":100,\"sampleQty\":10,\"plannedDate\":\"2026-07-31\",\"inspector\":\"测试员\"}";
        mvc.perform(post("/api/qms/inspections").header("Authorization","Bearer "+login())
                .contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.materialCode").value("MAT-TEST-01"))
                .andExpect(jsonPath("$.data.status").value("待检验"));
    }
    @Test void adminCanRecommendTightenedSamplingPlan() throws Exception {
        mvc.perform(post("/api/qms/sampling-plan").header("Authorization","Bearer "+login())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"materialCode\":\"MAT-RISK-01\",\"lotSize\":10000,\"historicalDefectRate\":0.03,\"supplierRisk\":80,\"criticalCharacteristic\":true,\"recentEscapes\":2}"))
            .andExpect(status().isOk()).andExpect(jsonPath("$.data.sampleSize").value(594))
            .andExpect(jsonPath("$.data.inspectionLevel").value("TIGHTENED"))
            .andExpect(jsonPath("$.data.acceptanceNumber").value(0));
    }
    @Test void anonymousRequestIsDenied() throws Exception {mvc.perform(get("/api/qms/dashboard")).andExpect(status().isForbidden());}
}
