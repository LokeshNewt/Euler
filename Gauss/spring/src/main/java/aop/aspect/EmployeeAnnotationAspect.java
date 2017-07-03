package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by neerbans on 6/19/2017.
 */

@Aspect
public class EmployeeAnnotationAspect {

    @Before("@annotation(aop.aspect.Loggable)")
    public void myAdvice(){
        System.out.println("Executing myAdvice!!");
    }
}
