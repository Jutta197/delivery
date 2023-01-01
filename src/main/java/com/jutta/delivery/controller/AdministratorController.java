package com.jutta.delivery.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jutta.delivery.common.R;
import com.jutta.delivery.entity.Administrator;
import com.jutta.delivery.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
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
//        1、将页面提交的密码password进行md5加密处理
        String password = administrator.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

//        2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Administrator> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Administrator::getUsername, administrator.getUsername());
        Administrator admi = administratorService.getOne(queryWrapper);

        // debug 第三步通不过，可能是数据库的问题？

//        3、如果没有查询到则返回登录失败结果
        if (admi == null) {
            return R.error("Login failed");
        }

//        4、密码比对，如果不一致则返回登录失败结果
        if (!admi.getPassword().equals(password)) {
            return R.error("Login failed");
        }

//        5、查看管理状态，如果为已禁用状态，则返回管理已禁用结果
        if (admi.getStatus() == 0) {
            return R.error("The account is disabled");
        }

//        6、登录成功，将管理id存入Session并返回登录成功结果
        request.getSession().setAttribute("administrator", admi.getId());
        return R.success(admi);


//        @PostMapping("/logout")
//        public R<String> logout(HttpServletRequest request){
//            request.getSession().removeAttribute("admi");
//            return R.success("退出成功")
//        }


    }
}
