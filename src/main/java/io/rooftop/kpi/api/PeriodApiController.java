package io.rooftop.kpi.api;

import io.rooftop.kpi.service.PeriodService;
import io.rooftop.kpi.service.dto.PeriodSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PeriodApiController {

    private final PeriodService periodService;

    @PostMapping("/api/period")
    public Long save(@RequestBody PeriodSaveRequestDto requestDto) {
        return periodService.saveKpi(requestDto);
    }

}
