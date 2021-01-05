package io.rooftop.agile.domain;

import io.rooftop.kpi.domain.Kpi;
import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class KpiTest {

    @Test
    public void Kpi생성() throws Exception {
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


        Kpi kpi = Kpi.builder()
                        .id(2L)
                        .fromDate(fromDate)
                        .toDate(toDate)
                        .build();

        kpi.addTask(task);

        // Then
        Assertions.assertThat(fromDate).isEqualTo(kpi.getFromDate());
        Assertions.assertThat(toDate).isEqualTo(kpi.getToDate());
        Assertions.assertThat(taskName).isEqualTo(kpi.getTasks().get(0).getTaskName());
        Assertions.assertThat(TaskType.Production).isEqualTo(kpi.getTasks().get(0).getTaskType());
        Assertions.assertThat(LevelStatus.High).isEqualTo(kpi.getTasks().get(0).getImpactStatus());
        Assertions.assertThat(LevelStatus.Medium).isEqualTo(kpi.getTasks().get(0).getComplexityStatus());

    }

}