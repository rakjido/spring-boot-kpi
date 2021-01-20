package io.rooftop.kpi.config;

import io.rooftop.kpi.domain.Period;
import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            Period period = Period.builder()
                        .fromDate(LocalDate.of(2021, 1, 4))
                        .toDate(LocalDate.of(2021,1,10))
                        .build();
            em.persist(period);

            Task task1 = Task.builder()
                            .taskName("In-Person Demo")
                            .taskType(TaskType.Revenue)
                            .impactStatus(LevelStatus.High)
                            .complexityStatus(LevelStatus.Medium)
                            .isFinished(Boolean.FALSE)
                            .build();
            em.persist(task1);
            period.addTask(task1);

            Task task2 = Task.builder()
                    .taskName("Add chat widget")
                    .taskType(TaskType.Revenue)
                    .impactStatus(LevelStatus.Medium)
                    .complexityStatus(LevelStatus.Low)
                    .isFinished(Boolean.FALSE)
                    .build();
            em.persist(task2);
            period.addTask(task2);

            Task task3 = Task.builder()
                    .taskName("Cold email for 100 potential users")
                    .taskType(TaskType.Revenue)
                    .impactStatus(LevelStatus.Low)
                    .complexityStatus(LevelStatus.Low)
                    .isFinished(Boolean.FALSE)
                    .build();
            em.persist(task3);
            period.addTask(task3);

        }
    }
}
