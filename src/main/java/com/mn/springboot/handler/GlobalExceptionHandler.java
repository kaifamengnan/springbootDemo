package com.mn.springboot.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mn.springboot.pojo.ResultBean;
import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exceptionHandler(Exception e){
        return new ResultBean("500","服务器错误");
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException e) throws JsonProcessingException {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String,String> message = new HashMap<>();
        for(FieldError fieldError : fieldErrors){
            message.put(fieldError.getField(),fieldError.getDefaultMessage());
            logger.error(fieldError.getField()+fieldError.getDefaultMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);
        return new ResultBean("400",json);
    }
}
