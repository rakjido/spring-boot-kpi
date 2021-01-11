package io.rooftop.kpi.api;

import io.rooftop.kpi.service.KpiService;
import io.rooftop.kpi.service.dto.KpiSaveRequestDto;
import io.rooftop.kpi.service.dto.TaskSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KpiApiController {

    private final KpiService kpiService;

    @PostMapping("/api/kpi")
    public Long save(@RequestBody KpiSaveRequestDto requestDto) {
        return kpiService.saveKpi(requestDto);
    }

}
