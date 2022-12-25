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

    // 管理登录

    @PostMapping("/login")
    public R<Administrator> login(HttpServletRequest request, @RequestBody Administrator administrator) {
       /* 1、将页面提交的密码password进行md5加密处理
        2、根据页面提交的用户名username查询数据库
        3、如果没有查询到则返回登录失败结果
        4、密码比对，如果不一致则返回登录失败结果
        5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        6、登录成功，将员工id存入Session并返回登录成功结果*/

        return null;
    }
}
