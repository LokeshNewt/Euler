package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by neerbans on 6/19/2017.
 */

@Aspect
public class EmployeeAspect {

    //The string parameter passed in the @Before annotation is the Pointcut expression
    @Before("execution(public String getName())")
    public void getNameAdvice() {
        System.out.println(" Executing Advice on getName()");
    }

    @Before("execution(* aop.service.*.get*())")
    public void getAllAdvice() {
        System.out.println("Service method getter called");
    }
}
