package com.business.common.Config;

import com.business.common.Utils.BusinessApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@DependsOn("BusinessApp")
public class DatabaseConfig {
    private BusinessApp businessApp;


    @Bean(name = "BusinessDataSource")
    public DataSource BusinessDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(businessApp.getBusinessConfig().getDatabaseConnection().getDatabaseDriver())
                .url(businessApp.getBusinessConfig().getDatabaseConnection().getDatabaseUrl())
                .username(businessApp.getBusinessConfig().getDatabaseConnection().getDatabaseUsername())
                .password(businessApp.getBusinessConfig().getDatabaseConnection().getDatabasePassword())
                .build();
    }

    @Bean(name = "BusinessDB")
    public JdbcTemplate BusinessDB(@Qualifier("BusinessDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Autowired
    public void setBusinessApp(BusinessApp businessApp) {
        this.businessApp = businessApp;
    }
}
