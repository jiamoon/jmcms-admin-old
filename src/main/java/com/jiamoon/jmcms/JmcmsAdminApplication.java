package com.jiamoon.jmcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Map;

/**
 * 启动类入口
 */
@EnableAutoConfiguration
@MapperScan("com.jiamoon.jmcms.modules")
@SpringBootApplication
public class JmcmsAdminApplication {
    @Value("${jmcms.adminPath}")
    String adminPath;

    public static void main(String[] args) {
        SpringApplication.run(JmcmsAdminApplication.class, args);
    }

    @Bean
    public CommandLineRunner customFreemarker(FreeMarkerViewResolver resolver) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                //添加自定义变量
                Map<String,Object> map = resolver.getAttributesMap();
                map.put("adminPath", adminPath);
            }
        };
    }
}
