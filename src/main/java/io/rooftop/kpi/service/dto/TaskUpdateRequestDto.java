package io.rooftop.kpi.service.dto;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.TaskType;
import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class TaskUpdateRequestDto {

    private String taskName;

    private Boolean isFinished;

    private TaskType taskType;

    private LevelStatus impactStatus;

    private LevelStatus complexityStatus;

    private String remarks;

    @Builder
    public TaskUpdateRequestDto(String taskName, Boolean isFinished, TaskType taskType, LevelStatus impactStatus, LevelStatus complexityStatus, String remarks) {
        this.taskName = taskName;
        this.isFinished = isFinished;
        this.taskType = taskType;
        this.impactStatus = impactStatus;
        this.complexityStatus = complexityStatus;
        this.remarks = remarks;
    }
}
