package io.rooftop.kpi.service;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.repository.KpiRepository;
import io.rooftop.kpi.repository.QueryTaskRepository;
import io.rooftop.kpi.service.dto.KpiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class KpiService {

    private final KpiRepository kpiRepository;
    private final QueryTaskRepository queryTaskRepository;

    public KpiResponseDto findKpiById(Long kpiId){
        Kpi kpi = kpiRepository.findById(kpiId)
                .orElseThrow(() -> new IllegalArgumentException("There's no kpi id :" + kpiId));
        return new KpiResponseDto(kpi);
    }

    public KpiResponseDto findLatestKpi() throws IllegalStateException {
        Long kpiId = queryTaskRepository.findLatestKpiId();
        return findKpiById(kpiId);
    }

}
