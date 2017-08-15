package com.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
* Created by neerbans on 7/28/2017.
*/

@EntityScan("entity")
@SpringBootApplication
        //(scanBasePackages = {"com.javabrains"})
public class CourseApiApp {

    public static void main (String args []) {
        SpringApplication.run(CourseApiApp.class, args);
    }
}
