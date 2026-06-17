package com.pluralsight.springcontrollerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringControllerDemoApplication {

    public static void main(String[] args) {
        ApplicationContext beaBag =  SpringApplication.run(SpringControllerDemoApplication.class, args);

    }
}
