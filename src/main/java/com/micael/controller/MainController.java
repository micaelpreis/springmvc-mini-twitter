package com.micael.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    // WELCOME PAGE
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        return "welcomePage";
    }

    // INDEX PAGE
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        return "indexPage";
    }

    // LOGIN PAGE
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
        return "loginPage";
    }
}