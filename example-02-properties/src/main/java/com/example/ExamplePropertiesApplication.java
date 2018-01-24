package com.example;

import com.example.modelCite.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class ExamplePropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplePropertiesApplication.class, args);
	}
}


/**
 * @SpringBootApplication
 * 等价于
 * @Configuration
 * @EnableAutoConfiguration ：借助@Import的帮助，将所有符合自动配置条件的bean定义加载到IoC容器
 * @ComponentScan ：自动扫描并加载符合条件的组件（比如@Component和@Repository等）或者bean定义，最终将这些bean定义加载到IoC容器中。
 *
 */
