package io.rooftop.agile.domain;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class TaskTest {

    @Test
    public void Task테스트() throws Exception {
        // Given
        String taskName = "KPI application";

        Task task = Task.builder()
                        .taskName(taskName)
                        .taskType(TaskType.Production)
                        .impactStatus(LevelStatus.High)
                        .complexityStatus(LevelStatus.Medium)
                        .build();

        // Then
        Assertions.assertThat(taskName).isEqualTo(task.getTaskName());
        Assertions.assertThat(TaskType.Production).isEqualTo(task.getTaskType());
        Assertions.assertThat(LevelStatus.High).isEqualTo(task.getImpactStatus());
        Assertions.assertThat(LevelStatus.Medium).isEqualTo(task.getComplexityStatus());

    }

}