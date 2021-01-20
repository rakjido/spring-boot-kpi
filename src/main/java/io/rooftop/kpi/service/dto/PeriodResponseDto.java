package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PeriodResponseDto {

    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;

    public PeriodResponseDto(Period period) {
        this.id = period.getId();
        this.fromDate = period.getFromDate();
        this.toDate = period.getToDate();
    }
}
