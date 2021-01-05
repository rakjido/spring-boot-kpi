package io.rooftop.kpi.service;

import io.rooftop.kpi.repository.KpiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class KpiService {

    private final KpiRepository kpiRepository;

//    public void addTask(TaskSaveRequestDto taskDto) {
//        Task task = Task.builder()
//                        .taskName(taskDto.getTaskName())
//                        .taskType(taskDto.getTaskType())
//                        .impactStatus(taskDto.getImpactStatus())
//                        .complexityStatus(taskDto.getComplexityStatus())
//                        .remarks(taskDto.getRemarks())
//                        .build();
//        kpi.addTask(task);
//        kpiRepository.save(kpi);
//    }
}
