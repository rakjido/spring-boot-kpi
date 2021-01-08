package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class TaskResponseMustacheDto {

    private Long id;

    private String taskName;

    private Boolean isFinished;

    private TaskType taskType;

    private Boolean isImpactStatusHigh;
    private Boolean isImpactStatusMedium;
    private Boolean isImpactStatusLow;

    private Boolean isComplexityStatusHigh;
    private Boolean isComplexityStatusMedium;
    private Boolean isComplexityStatusLow;

    private String remarks;

    private Kpi kpi;

    @Builder
    public TaskResponseMustacheDto(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.isFinished = task.getIsFinished();
        this.taskType = task.getTaskType();
        this.remarks = task.getRemarks();
        this.kpi = task.getKpi();

        this.isImpactStatusHigh = (task.getImpactStatus().equals(LevelStatus.High)) ? true : false;
        this.isImpactStatusMedium = (task.getImpactStatus().equals(LevelStatus.Medium)) ? true : false;
        this.isImpactStatusLow = (task.getImpactStatus().equals(LevelStatus.Low)) ? true : false;

        this.isComplexityStatusHigh = (task.getComplexityStatus().equals(LevelStatus.High)) ? true : false;
        this.isComplexityStatusMedium = (task.getComplexityStatus().equals(LevelStatus.Medium)) ? true : false;
        this.isComplexityStatusLow = (task.getComplexityStatus().equals(LevelStatus.Low)) ? true : false;

    }
}
