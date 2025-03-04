package com.employee.employeeapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="com.employee.employeeapp")
public class CustomProperties {

    private String apiUrl;
}
