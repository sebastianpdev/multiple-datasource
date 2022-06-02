package com.example.demo.constant;

import com.example.demo.security.DataSourceRouting;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class DataSourceRoutingSingleton {
    public DataSourceRouting dataSourceRouting;
}