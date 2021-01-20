package io.rooftop.kpi.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class TaskTest {

    @Test
    public void create_task_test() throws Exception {
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