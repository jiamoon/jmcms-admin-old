package com.jiamoon.jmcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类入口
 */
@EnableAutoConfiguration
@MapperScan("com.jiamoon.jmcms.modules")
@SpringBootApplication
public class JmcmsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmcmsAdminApplication.class, args);
	}
}
