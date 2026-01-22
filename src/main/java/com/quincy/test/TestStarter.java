package com.quincy.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan(basePackages = {"com.quincy.test.mapper"})
@EnableTransactionManagement
@EnableWebMvc
@EnableAutoConfiguration
//(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication/*(exclude = {
        DataSourceAutoConfiguration.class
})*/
@ComponentScan(basePackages= {"com.*"})
public class TestStarter {
    public static void main(String[] args) {
    	System.setProperty("zookeeper.sasl.client", "false");
    	SpringApplication sa = new SpringApplication(TestStarter.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }
}