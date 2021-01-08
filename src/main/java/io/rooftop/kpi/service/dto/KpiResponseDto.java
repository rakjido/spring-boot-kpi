package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class KpiResponseDto {

    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;

    public KpiResponseDto(Kpi kpi) {
        this.id = kpi.getId();
        this.fromDate = kpi.getFromDate();
        this.toDate = kpi.getToDate();
    }
}
