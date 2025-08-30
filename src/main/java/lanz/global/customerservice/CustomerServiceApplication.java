package lanz.global.customerservice;

import lanz.global.customerservice.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "lanz.global.libraryservice")
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties(ServiceConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
