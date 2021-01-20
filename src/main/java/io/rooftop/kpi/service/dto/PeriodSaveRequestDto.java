package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class PeriodSaveRequestDto {
    private LocalDate fromDate;
    private LocalDate toDate;

    public Period toEntity() {
        return Period.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .build();
    }

}
