package io.rooftop.kpi.service;

import io.rooftop.kpi.domain.Period;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.repository.PeriodRepository;
import io.rooftop.kpi.repository.QueryTaskRepository;
import io.rooftop.kpi.repository.TaskRepository;
import io.rooftop.kpi.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final PeriodRepository periodRepository;
    private final QueryTaskRepository queryTaskRepository;

    @Transactional
    public Long saveTask(TaskSaveRequestDto requestDto) {
        Task task = requestDto.toEntity();
        Long kpiId = requestDto.getPeriodId();
        Period period = periodRepository.findById(kpiId)
                .orElseThrow(() -> new IllegalArgumentException("There's no kpi id :" + kpiId));
        task.setPeriod(period);
        return taskRepository.save(task).getId();
    }

    @Transactional
    public Long updateTask(Long taskId, TaskUpdateRequestDto requestDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("There's no taks id :" + taskId));
        task.update(requestDto.getTaskName(), requestDto.getIsFinished(), requestDto.getTaskType(),
                    requestDto.getImpactStatus(), requestDto.getComplexityStatus(),requestDto.getRemarks());
        return taskId;
    }

    @Transactional
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("There's no taks id :" + taskId));
        taskRepository.delete(task);
    }

    public TaskResponseDto findTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("There's no taks id :" + taskId));
        return new TaskResponseDto(task);
    }

    public TaskResponseMustacheDto findTaskByIdReturnMustache(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("There's no taks id :" + taskId));
        return new TaskResponseMustacheDto(task);
    }

    public List<TaskListResponseDto> findAllTasksDesc() {
        return taskRepository.findAllDesc().stream()
                .map(TaskListResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<TaskListResponseDto> findAllByImpactComplexity() {
        Long kpiId = queryTaskRepository.findLatestperiodId();
        return queryTaskRepository.findAllbyImpactCompexity(kpiId).stream()
                .map(TaskListResponseDto::new)
                .collect(Collectors.toList());
    }
}
