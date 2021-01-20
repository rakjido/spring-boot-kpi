package io.rooftop.kpi.web;

import io.rooftop.kpi.service.PeriodService;
import io.rooftop.kpi.service.TaskService;
import io.rooftop.kpi.service.dto.TaskResponseMustacheDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class KpiController {

    private final PeriodService periodService;
    private final TaskService taskService;

    @GetMapping("/kpi")
    public String kpiList(Model model){
        model.addAttribute("period", periodService.findLatestPeriod());
        model.addAttribute("tasks", taskService.findAllByImpactComplexity());
        return "kpi";
    }

    @GetMapping("/kpi/save")
    public String taskSave(Model model) {
        model.addAttribute("period", periodService.findLatestPeriod());
        return "task-save";
    }

    @GetMapping("/kpi/update/{id}")
    public String taskUpdate(@PathVariable Long id, Model model) {
//        TaskResponseDto task = taskService.findTaskById(id);
        TaskResponseMustacheDto task = taskService.findTaskByIdReturnMustache(id);
        model.addAttribute("period", periodService.findLatestPeriod());
        model.addAttribute("task", task);
        return "task-update";
    }

    @GetMapping("/kpi/delete/{id}")
    public String taskDelete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/kpi";
    }
}
