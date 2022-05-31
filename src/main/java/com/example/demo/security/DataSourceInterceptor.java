package com.example.demo.security;

import com.example.demo.config.BranchContextHolder;
import com.example.demo.constant.DataSourceRoutingSingleton;
import com.example.demo.entity.DatasourceOneDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private DatasourceOneDetail datasourceOneDetail;

    @Autowired
    DataSourceRoutingSingleton dataSourceRoutingSingleton;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        BranchContextHolder.clearBranchContext();
        dataSourceRoutingSingleton.dataSourceRouting.initDatasourceCustom(datasource1(request.getHeader("userDB"),
                request.getHeader("passwordDB")), request.getHeader("userDB"));

        BranchContextHolder.setBranchContext(request.getHeader("userDB"));
        return super.preHandle(request, response, handler);
    }

    private DataSource datasource1(String u, String p) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(datasourceOneDetail.getUrl());
        dataSource.setUsername(u);
        dataSource.setPassword(p);
        return dataSource;
    }
}
