package io.rooftop.kpi.web;

import io.rooftop.kpi.service.TaskService;
import io.rooftop.kpi.web.dto.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class KpiController {

    private final TaskService taskService;

    @GetMapping("/kpi")
    public String kpiList(Model model){
        model.addAttribute("tasks", taskService.findAllByImpactComplexity());
        return "kpi";
    }

    @GetMapping("/kpi/save")
    public String taskSave() {
        return "task-save";
    }

    @GetMapping("/kpi/update/{id}")
    public String taskUpdate(@PathVariable Long id, Model model) {
        TaskResponseDto task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }
}
