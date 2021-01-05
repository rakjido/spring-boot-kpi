package io.rooftop.kpi.service;

import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.repository.TaskRepository;
import io.rooftop.kpi.web.dto.TaskListResponseDto;
import io.rooftop.kpi.web.dto.TaskResponseDto;
import io.rooftop.kpi.web.dto.TaskSaveRequestDto;
import io.rooftop.kpi.web.dto.TaskUpdateRequestDto;
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

    @Transactional
    public Long saveTask(TaskSaveRequestDto requestDto) {
        return taskRepository.save(requestDto.toEntity()).getId();
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

    public List<TaskListResponseDto> findAllTasksDesc() {
        return taskRepository.findAllDesc().stream()
                .map(TaskListResponseDto::new)
                .collect(Collectors.toList());
    }
}
