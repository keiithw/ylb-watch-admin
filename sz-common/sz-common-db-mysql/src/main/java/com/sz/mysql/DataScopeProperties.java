package com.sz.mysql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "sz.data-scope")
public class DataScopeProperties {

    private boolean enabled = true;

    private String logicMinUnit = "user";

}
