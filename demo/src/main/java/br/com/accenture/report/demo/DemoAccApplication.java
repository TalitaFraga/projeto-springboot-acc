package br.com.accenture.report.demo;

import br.com.accenture.report.demo.controller.ContaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = "br.com.accenture.report.demo.model")
@ComponentScan(basePackages = "br.com.accenture.report.demo.*")
@EnableJpaRepositories(basePackages = "br.com.accenture.report.demo.repository")
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration

public class DemoAccApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoAccApplication.class, args);
    }
}