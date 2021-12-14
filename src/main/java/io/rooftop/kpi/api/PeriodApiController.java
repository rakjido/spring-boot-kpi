package io.rooftop.kpi.api;

import io.rooftop.kpi.service.PeriodService;
import io.rooftop.kpi.service.dto.PeriodResponseDto;
import io.rooftop.kpi.service.dto.PeriodSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PeriodApiController {

    private final PeriodService periodService;

    @PostMapping("/api/periods")
    public ResponseEntity<Long> save(@RequestBody PeriodSaveRequestDto requestDto) {
        return new ResponseEntity<>(periodService.saveKpi(requestDto), HttpStatus.OK);
    }

    @GetMapping("/api/periods")
    public ResponseEntity<PeriodResponseDto> getLastPeriod() {
        return new ResponseEntity<>(periodService.findLatestPeriod(), HttpStatus.OK);
    }
}
