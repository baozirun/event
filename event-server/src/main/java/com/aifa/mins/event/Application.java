package com.aifa.mins.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 微应用服务核心启动类
 * 
 * @author Jason zou
 * @version 5.0.0
 * @since 2018.9.7
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.aifa.mins")
@EnableFeignClients("com.aifa.mins")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
