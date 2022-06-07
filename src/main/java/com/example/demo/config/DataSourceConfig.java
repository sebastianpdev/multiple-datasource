package com.example.demo.config;

import com.example.demo.constant.DataSourceRoutingSingleton;
import com.example.demo.entity.DatasourceOneDetail;
import com.example.demo.entity.User;
import com.example.demo.security.DataSourceRouting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.repository",
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
    private DatasourceOneDetail datasourceOneDetail;

    @Autowired
    DataSourceRoutingSingleton dataSourceRoutingSingleton;

    @Bean
    @Primary
    public DataSource dataSource() {
        dataSourceRoutingSingleton.dataSourceRouting = new DataSourceRouting();
        dataSourceRoutingSingleton.dataSourceRouting.initDatasource(datasource1());
        return dataSourceRoutingSingleton.dataSourceRouting;
    }

    private DataSource datasource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(datasourceOneDetail.getUrl());
        dataSource.setUsername(datasourceOneDetail.getUsername());
        dataSource.setPassword(datasourceOneDetail.getPassword());
        dataSource.setSchema("AUDITORIA");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages(User.class)
                .build();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }

}
