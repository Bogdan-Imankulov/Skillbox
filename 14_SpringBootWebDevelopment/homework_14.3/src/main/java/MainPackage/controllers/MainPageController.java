package mainPackage.controllers;

import mainPackage.entities.Task;
import mainPackage.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainPageController {

    public static TaskService service;

    @Autowired
    public MainPageController(TaskService repo) {
        MainPageController.service = repo;
    }

    @RequestMapping("/")
    public String index(Model model){
        List<Task> list = service.findALl();
        model.addAttribute("tasksList", list);
        model.addAttribute("tasksCount", list.size());
        return "mainPage";
    }
}
