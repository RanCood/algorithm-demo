package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author zg
 * @date 2019/2/15 17:33
 */
@Configuration
@Slf4j
public class DruidDatasourceConfig {

    @Bean
    @ConfigurationProperties("guard.datasource")
    public DataSource guardDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        log.info("guardDruidDataSource info {}", druidDataSource);
        return druidDataSource;
    }

    @Bean
    @Resource
    public PlatformTransactionManager guardTxManager(DataSource guardDataSource) {
        return new DataSourceTransactionManager(guardDataSource);
    }

    @Bean
    @Resource
    public JdbcTemplate guardJdbcTemplate(DataSource guardDataSource) {
        return new JdbcTemplate(guardDataSource);
    }


    @Bean
    @ConfigurationProperties("rule.datasource")
    public DataSource ruleDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        log.info("ruleDruidDataSource info {}", druidDataSource);
        return druidDataSource;
    }

    @Bean
    @Resource
    public PlatformTransactionManager ruleTxManager(DataSource ruleDataSource) {
        return new DataSourceTransactionManager(ruleDataSource);
    }

    @Bean
    @Resource
    public JdbcTemplate ruleJdbcTemplate(DataSource ruleDataSource) {
        return new JdbcTemplate(ruleDataSource);
    }

//    @Bean
//    @ConfigurationProperties("guard.datasource")
//    public DataSourceProperties guardDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource guardDataSource(DataSourceProperties guardDataSourceProperties) {
//        log.info("guard datasource url: {}", guardDataSourceProperties.getUrl());
//        return guardDataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    @Resource
//    public JdbcTemplate guardJdbcTemplate(DataSource guardDataSource) {
//        return new JdbcTemplate(guardDataSource);
//    }
//
//    @Bean
//    @Resource
//    public PlatformTransactionManager guardTxManager(DataSource guardDataSource) {
//        return new DataSourceTransactionManager(guardDataSource);
//    }
//
//    @Bean
//    @ConfigurationProperties("rule.datasource")
//    public DataSourceProperties ruleDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource ruleDataSource(DataSourceProperties ruleDataSourceProperties) {
//        log.info("rule datasource url: {}", ruleDataSourceProperties.getUrl());
//        return ruleDataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    @Resource
//    public JdbcTemplate ruleJdbcTemplate(DataSource ruleDataSource) {
//        return new JdbcTemplate(ruleDataSource);
//    }
//
//    @Bean
//    @Resource
//    public PlatformTransactionManager ruleTxManager(DataSource ruleDataSource) {
//        return new DataSourceTransactionManager(ruleDataSource);
//    }

}
