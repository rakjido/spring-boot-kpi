package io.rooftop.kpi.api;

import io.rooftop.kpi.service.TaskService;
import io.rooftop.kpi.service.dto.TaskListResponseDto;
import io.rooftop.kpi.service.dto.TaskResponseDto;
import io.rooftop.kpi.service.dto.TaskSaveRequestDto;
import io.rooftop.kpi.service.dto.TaskUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("/api/tasks")
    public ResponseEntity<Long> save(@RequestBody TaskSaveRequestDto requestDto) {
        return new ResponseEntity<>(taskService.saveTask(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody TaskUpdateRequestDto requestDto){
        return new ResponseEntity<>(taskService.updateTask(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findTaskById(id),HttpStatus.OK);
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<TaskListResponseDto>> findAll() {

        return new ResponseEntity<>(taskService.findAllByImpactComplexity(), HttpStatus.OK);
//        return taskService.findAllTasksDesc();
    }
}