package com.mn.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mn.springboot.entity.User;
import com.mn.springboot.pojo.ResultBean;
import com.mn.springboot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @PostMapping("add")
    public ResultBean add(@Valid User user){
        logger.info("用户添加成功");
        return new ResultBean("success","ok");
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }


}
