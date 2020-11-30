package com.course.springboot.starter.springbootstarter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/message")
    public String getMessage(@RequestParam(value = "message", defaultValue = "World") String message) {
        String greeting = messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
        message = String.format("%s %s!", greeting, message);
        LOG.debug(message);
        return message;
    }
}
