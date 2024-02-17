package br.com.elwgomes.multimodule.cleanarchitecture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.elwgomes"})
@EntityScan(basePackages = {"br.com.elwgomes"})
public class PoCMultiModuleCleanArchitectureSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoCMultiModuleCleanArchitectureSpringBootApplication.class, args);
        System.out.println("Application is running on...");
    }
}

