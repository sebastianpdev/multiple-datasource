package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "datasource1.datasource")
public class DatasourceOneDetail {

    private String url;
    private String password;
    private String username;
}
