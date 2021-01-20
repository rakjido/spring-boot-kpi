package io.rooftop.kpi.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class PeriodTest {

    @Test
    public void Period_Create_Test() throws Exception {
        // Given
        LocalDate fromDate = LocalDate.of(2020, 11, 23);
        LocalDate toDate = LocalDate.of(2020, 12, 01);

        String taskName = "KPI Application";
        Task task = Task.builder()
                        .taskName(taskName)
                        .taskType(TaskType.Production)
                        .impactStatus(LevelStatus.High)
                        .complexityStatus(LevelStatus.Medium)
                        .build();


        Period period = Period.builder()
                        .id(2L)
                        .fromDate(fromDate)
                        .toDate(toDate)
                        .build();

        period.addTask(task);

        // Then
        Assertions.assertThat(fromDate).isEqualTo(period.getFromDate());
        Assertions.assertThat(toDate).isEqualTo(period.getToDate());
        Assertions.assertThat(taskName).isEqualTo(period.getTasks().get(0).getTaskName());
        Assertions.assertThat(TaskType.Production).isEqualTo(period.getTasks().get(0).getTaskType());
        Assertions.assertThat(LevelStatus.High).isEqualTo(period.getTasks().get(0).getImpactStatus());
        Assertions.assertThat(LevelStatus.Medium).isEqualTo(period.getTasks().get(0).getComplexityStatus());

    }

}