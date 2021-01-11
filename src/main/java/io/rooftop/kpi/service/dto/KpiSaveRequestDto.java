package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class KpiSaveRequestDto {
    private LocalDate fromDate;
    private LocalDate toDate;

    public Kpi toEntity() {
        return Kpi.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .build();
    }

}
