package io.rooftop.kpi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
//    @GetMapping("/")
//    public RedirectView hello() {
//        return new RedirectView("/kpi");
//    }
    @GetMapping("/")
    public String hello() {
        return "redirect:/kpi";
    }

}
