package com.example.demo.security;

import com.example.demo.config.BranchContextHolder;
import com.example.demo.constant.BranchEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceRouting extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return BranchContextHolder.getBranchContext();
    }

    public void initDatasource(DataSource datasource1) {
        this.determineCurrentLookupKey();
        BranchContextHolder.setBranchContext("DATASOURCE1");
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(BranchEnum.DATASOURCE1.toString(), datasource1);
        this.setTargetDataSources(dataSourceMap);
    }

    public void initDatasourceCustom(DataSource datasource1, String user) {
        this.determineCurrentLookupKey();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(user, datasource1);
        this.setTargetDataSources(dataSourceMap);
        this.afterPropertiesSet();
    }
}
