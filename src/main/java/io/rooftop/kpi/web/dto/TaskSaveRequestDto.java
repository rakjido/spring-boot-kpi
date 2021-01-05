package io.rooftop.kpi.web.dto;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class TaskSaveRequestDto {

    private String taskName;

    private Boolean isFinished;

    private TaskType taskType;

    private LevelStatus impactStatus;

    private LevelStatus complexityStatus;

    private String remarks;

    public Task toEntity() {
        return Task.builder()
                .taskName(taskName)
                .isFinished(isFinished)
                .taskType(taskType)
                .impactStatus(impactStatus)
                .complexityStatus(complexityStatus)
                .remarks(remarks)
                .build();
    }
}