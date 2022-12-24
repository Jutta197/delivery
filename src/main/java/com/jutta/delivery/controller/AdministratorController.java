package com.jutta.delivery.controller;

import com.jutta.delivery.common.R;
import com.jutta.delivery.entity.Administrator;
import com.jutta.delivery.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    public R<Administrator> login(HttpServletRequest request, @RequestBody Administrator administrator) {
        return null;
    }
}
