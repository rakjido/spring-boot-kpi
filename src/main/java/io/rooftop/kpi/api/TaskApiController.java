package io.rooftop.kpi.api;

import io.rooftop.kpi.service.TaskService;
import io.rooftop.kpi.service.dto.TaskListResponseDto;
import io.rooftop.kpi.service.dto.TaskResponseDto;
import io.rooftop.kpi.service.dto.TaskSaveRequestDto;
import io.rooftop.kpi.service.dto.TaskUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("/api/tasks")
    public Long save(@RequestBody TaskSaveRequestDto requestDto) {
        return taskService.saveTask(requestDto);
    }

    @PutMapping("/api/tasks/{id}")
    public Long update(@PathVariable Long id, @RequestBody TaskUpdateRequestDto requestDto){
        return taskService.updateTask(id, requestDto);
    }

    @DeleteMapping("/api/tasks/{id}")
    public Long delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return id;
    }

    @GetMapping("/api/tasks/{id}")
    public TaskResponseDto findById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @GetMapping("/api/tasks/list")
    public List<TaskListResponseDto> findAll() {

          return taskService.findAllByImpactComplexity();
//        return taskService.findAllTasksDesc();
    }
}
