package io.rooftop.kpi.service;

import io.rooftop.kpi.domain.Period;
import io.rooftop.kpi.repository.PeriodRepository;
import io.rooftop.kpi.repository.QueryTaskRepository;
import io.rooftop.kpi.service.dto.PeriodResponseDto;
import io.rooftop.kpi.service.dto.PeriodSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PeriodService {

    private final PeriodRepository periodRepository;
    private final QueryTaskRepository queryTaskRepository;

    @Transactional
    public Long saveKpi(PeriodSaveRequestDto requestDto) {
        return periodRepository.save(requestDto.toEntity()).getId();
    }

    public PeriodResponseDto findPeriodById(Long kpiId){
        Period period = periodRepository.findById(kpiId)
                .orElseThrow(() -> new IllegalArgumentException("There's no kpi id :" + kpiId));
        return new PeriodResponseDto(period);
    }

    public PeriodResponseDto findLatestPeriod() throws IllegalStateException {
        Long kpiId = queryTaskRepository.findLatestperiodId();
        return findPeriodById(kpiId);
    }

}
