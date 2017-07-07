package com.paris.backend.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by achen on 2017/7/6 0006.
 */
@Configuration
public class GlobalDataConfiguration
{
    @Bean(name="primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="datasource.primary")
    public DataSource primaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="secondaryDataSource")
    @ConfigurationProperties(prefix="datasource.secondary")
    public DataSource secondaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }
}