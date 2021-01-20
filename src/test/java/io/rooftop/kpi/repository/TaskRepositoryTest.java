package io.rooftop.kpi.repository;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.domain.TaskType;
import org.junit.After;
import org.junit.Assert;
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
    public void save_테스트() throws Exception {
        // Given
        Task savedTask = taskRepository.save(Task.builder()
                .taskName("test")
                .taskType(TaskType.Revenue)
                .impactStatus(LevelStatus.High)
                .complexityStatus(LevelStatus.Medium)
                .build());

        // When

        // Then
        Assert.assertNotNull(savedTask);
    }


    @Test
    public void findById_테스트()  throws Exception {
        // Given
        Task savedTask = taskRepository.save(Task.builder()
                .taskName("test")
                .taskType(TaskType.Revenue)
                .impactStatus(LevelStatus.High)
                .complexityStatus(LevelStatus.Medium)
                .build());
        // When
        Task findTask = taskRepository.findById(savedTask.getId()).get();

        // Then
        assertThat(findTask.getTaskName()).isEqualTo("test");
        assertThat(findTask.getImpactStatus()).isEqualTo(LevelStatus.High);
    }


}