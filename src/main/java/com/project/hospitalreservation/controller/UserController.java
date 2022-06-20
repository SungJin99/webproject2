package com.project.hospitalreservation.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.hospitalreservation.service.UserService;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
}
