package springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ContetNegotiation {

    public static void main(String[] args) {
        SpringApplication.run(ContetNegotiation.class, args);
    }
}