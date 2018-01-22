package job.admin.controller;

import job.admin.service.VieshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequestMapping("/vieshow")
@Controller
public class VieshowController {

    @Autowired
    private VieshowService vieshowService;

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String mname){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        model.addAttribute("movielist",vieshowService.queryMove(formatter.format(LocalDateTime.now()),mname));

        return "vieshow";
    }
}
