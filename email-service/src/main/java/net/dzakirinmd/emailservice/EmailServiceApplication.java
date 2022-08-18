package net.dzakirinmd.emailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * added @ComponentScan here to scan for OrderDTORepository
 */
@SpringBootApplication
@ComponentScan(basePackages = {"net.dzakirinmd"})
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
