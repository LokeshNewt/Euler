package aop.model;

import aop.aspect.Loggable;

/**
 * Created by neerbans on 6/19/2017.
 */
public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    // to showcase the use of AfterThrowing Advice
    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }
}
