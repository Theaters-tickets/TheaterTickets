package com.netcracker.theater.rtickets.data.controller.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class testController {

    @GetMapping("/userPage")
    public String userPage(Map<String, Object> model)
    {
        return "userPage";
    }

    @GetMapping("/adminPage")
    public String adminPage(Map<String, Object> model)
    {
        return "adminPage";
    }

    @GetMapping("/allPage")
    public String allPage(Map<String, Object> model){ return "allPage";}

    @GetMapping("/noReg")
    public String noReg(Map<String, Object> model){ return "noReg";}

}
