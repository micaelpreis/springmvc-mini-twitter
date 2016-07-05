package com.micael.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorHandlerController {


    // 401 ERROR PAGE
    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String unauthorised(Model model) {
        return "/errors/401";
    }

    // 403 ERROR PAGE
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {
        return "/errors/403";
    }

    // 404 ERROR PAGE
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFound(Model model) {
        return "/errors/404";
    }
}
