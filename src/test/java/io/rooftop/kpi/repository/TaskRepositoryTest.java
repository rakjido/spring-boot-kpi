package io.rooftop.kpi.repository;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @After
    public void cleanUp() {
        taskRepository.deleteAll();
    }

    @Test
    public void findById_테스트()  throws Exception {
        // Given
        taskRepository.save(Task.builder()
                                .taskName("test")
                                .taskType(TaskType.Revenue)
                                .impactStatus(LevelStatus.High)
                                .complexityStatus(LevelStatus.Medium)
                                .build());
        // When
        // initDb.java에서 3개의 task를 입력하기 때문에 4L
        Task findTask = taskRepository.findById(4L).get();

        // Then
        assertThat(findTask.getTaskName()).isEqualTo("test");
        assertThat(findTask.getImpactStatus()).isEqualTo(LevelStatus.High);
    }


}