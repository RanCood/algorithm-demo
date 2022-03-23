//package com.example.demo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class
//        , DataSourceTransactionManagerAutoConfiguration.class
//        , JdbcTemplateAutoConfiguration.class})
//@Slf4j
//public class Application {
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//
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
////
////    @Bean
////    @Resource
////    public PlatformTransactionManager guardTxManager(DataSource guardDataSource) {
////        return new DataSourceTransactionManager(guardDataSource);
////    }
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
////    @Bean
////    @Resource
////    public PlatformTransactionManager ruleTxManager(DataSource ruleDataSource) {
////        return new DataSourceTransactionManager(ruleDataSource);
////    }
//}
