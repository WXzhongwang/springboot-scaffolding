package com.dick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shengwangzhong
 */
@SpringBootApplication
public class CommandLineRunnerApplication {

    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(CommandLineRunnerApplication.class, args);
        System.out.println("The service has started.");
    }
}
