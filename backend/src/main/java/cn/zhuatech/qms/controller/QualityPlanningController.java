/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.qms.controller;

import cn.zhuatech.qms.common.ApiResponse;
import cn.zhuatech.qms.service.SamplingPlanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qms")
public class QualityPlanningController {
    private final SamplingPlanService service;
    public QualityPlanningController(SamplingPlanService service) { this.service = service; }

    @PostMapping("/sampling-plan")
    public ApiResponse<SamplingPlanService.Result> recommend(@Valid @RequestBody SamplingPlanService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
