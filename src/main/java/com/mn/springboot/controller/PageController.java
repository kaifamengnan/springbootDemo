package com.mn.springboot.controller;

import com.mn.springboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/hello")
    public String hello(Model model){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        User user = new User(1,"david","123");
        model.addAttribute("user",user);
        return "hello";
    }

}
