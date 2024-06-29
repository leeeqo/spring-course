package com.zt.spring.mvc;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String getFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String getEmployeeName(Model model) {
        Employee employee = new Employee("Name", "Surname", 0, "Department");
        model.addAttribute("employee", employee); //new Employee());

        return "get-employee-view";
    }

    @RequestMapping("/showDetails")
    public String showEmployeeName(@ModelAttribute("employee") Employee emp) {
        return "show-employee-view";
    }
}
