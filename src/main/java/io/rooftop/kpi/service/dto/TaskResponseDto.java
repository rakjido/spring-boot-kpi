package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TaskResponseDto {

    private Long id;

    private String taskName;

    private Boolean isFinished;

    private TaskType taskType;

    private LevelStatus impactStatus;

    private LevelStatus complexityStatus;

    private String remarks;

    private Kpi kpi;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.isFinished = task.getIsFinished();
        this.taskType = task.getTaskType();
        this.impactStatus = task.getImpactStatus();
        this.complexityStatus = task.getComplexityStatus();
        this.remarks = task.getRemarks();
        this.kpi = task.getKpi();
    }
}
