package com.javabrains.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neerbans on 8/2/2017.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi";
    }
}
