package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class TaskListResponseDto {
    private Long id;

    private String taskName;

    private Boolean isFinished;

    private TaskType taskType;

    private LevelStatus impactStatus;

    private LevelStatus complexityStatus;

    private String remarks;

    public TaskListResponseDto(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.isFinished = task.getIsFinished();
        this.taskType = task.getTaskType();
        this.impactStatus = task.getImpactStatus();
        this.complexityStatus = task.getComplexityStatus();
        this.remarks = task.getRemarks();
    }
}
