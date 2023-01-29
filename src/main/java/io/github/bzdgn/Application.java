package io.github.bzdgn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.bzdgn")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
