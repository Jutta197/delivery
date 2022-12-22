package com.jutta.delivery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jutta.delivery.entity.Administrator;
import com.jutta.delivery.mapper.AdministratorMapper;
import com.jutta.delivery.service.AdministratorService;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {
}
