package io.rooftop.kpi.service;

import io.rooftop.kpi.domain.LevelStatus;
import io.rooftop.kpi.domain.Task;
import io.rooftop.kpi.repository.PeriodRepository;
import io.rooftop.kpi.repository.QueryTaskRepository;
import io.rooftop.kpi.repository.TaskRepository;
import io.rooftop.kpi.service.dto.TaskResponseDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private PeriodRepository periodRepository;

    @Mock
    private QueryTaskRepository queryTaskRepository;

    private TaskService taskService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        taskService = new TaskService(taskRepository, periodRepository, queryTaskRepository);
    }

    @Test
    public void findTaskById_test() throws Exception {
        // Given
        Task task = Task.builder()
                .taskName("test mock")
                .impactStatus(LevelStatus.High)
                .complexityStatus(LevelStatus.Medium)
                .build();
        given(taskRepository.findById(1L))
                .willReturn(java.util.Optional.ofNullable(task));
        // When
        TaskResponseDto findTask = taskService.findTaskById(1L);
        // Then
        verify(taskRepository, times(1)).findById(1L);
        assertThat(findTask.getTaskName()).isEqualTo(task.getTaskName());
    }
}
