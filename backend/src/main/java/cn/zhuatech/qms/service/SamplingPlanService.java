/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.qms.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SamplingPlanService {
    public Result recommend(Request request) {
        double multiplier = 1 + request.historicalDefectRate() * 4
            + request.supplierRisk() / 100.0 + (request.criticalCharacteristic() ? .75 : 0)
            + request.recentEscapes() * .15;
        int sampleSize = Math.min(request.lotSize(), Math.max(5,
            (int) Math.ceil(Math.sqrt(request.lotSize()) * 2 * multiplier)));
        String inspectionLevel = request.criticalCharacteristic() || request.supplierRisk() >= 70
            || request.recentEscapes() > 0 ? "TIGHTENED" : request.supplierRisk() >= 40 ? "NORMAL" : "REDUCED";
        int acceptanceNumber = request.criticalCharacteristic() ? 0
            : (int) Math.floor(sampleSize * Math.max(.005, .02 - request.historicalDefectRate()));
        List<String> actions = new ArrayList<>();
        if (request.criticalCharacteristic()) actions.add("关键特性执行零接收数判定");
        if (request.supplierRisk() >= 70) actions.add("供应商来料切换至加严检验");
        if (request.recentEscapes() > 0) actions.add("增加逸出问题关联检验项目");
        if (actions.isEmpty()) actions.add("按推荐样本量执行常规抽样");
        return new Result(request.materialCode(), sampleSize, inspectionLevel, acceptanceNumber, actions);
    }

    public record Request(@NotBlank String materialCode, @Positive int lotSize,
                          @DecimalMin("0") @DecimalMax("1") double historicalDefectRate,
                          @Min(0) @Max(100) int supplierRisk, boolean criticalCharacteristic,
                          @Min(0) int recentEscapes) {}
    public record Result(String materialCode, int sampleSize, String inspectionLevel,
                         int acceptanceNumber, List<String> actions) {}
}
