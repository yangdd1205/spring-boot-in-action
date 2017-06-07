package com.slowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		//屏蔽命令行访问属性的设置
		//app.setAddCommandLineProperties(false);
		app.run(args);
	}
}
