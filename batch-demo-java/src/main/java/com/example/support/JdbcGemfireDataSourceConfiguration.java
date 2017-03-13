/*
package com.example.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class JdbcGemfireDataSourceConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcGemfireDataSourceConfiguration.class);

    @Autowired
    private JdbcGemfireDataSourceProperties props;

    @Autowired
    private Environment environment;

    @Bean(name = "taskDataSource")
    @Primary
    public DataSource taskDataSource() {
        return getDefaultDataSource();
    }


    @Bean(name = "JdbcGemfireDataSource")
    public DataSource jdbcGemfireDataSource() {
        DataSource dataSource;
        if (props.getUrl() != null && props.getUsername() != null) {
            LOG.info("JDBC Datasource profile=[Provided]");
            LOG.info("jdbcGemfireDataSource initial properties [URL:{}, UserName:{}, DriverClassName:{}]", props.getUrl(), props.getUsername(), props.getDriverClassName());
            dataSource = DataSourceBuilder.create().driverClassName(props.getDriverClassName())
                    .url(props.getUrl())
                    .username(props.getUsername())
                    .password(props.getPassword()).build();
        } else {
            dataSource = getDefaultDataSource();
            LOG.info("JDBC Datasource profile=[DEFAULT]");
        }
        return dataSource;
    }

    private DataSource getDefaultDataSource() {
        return DataSourceBuilder.create().driverClassName(environment.getProperty("spring.datasource.driverClassName"))
                .url(environment.getProperty("spring.datasource.url"))
                .username(environment.getProperty("spring.datasource.username"))
                .password(environment.getProperty("spring.datasource.password")).build();
    }
}
*/
