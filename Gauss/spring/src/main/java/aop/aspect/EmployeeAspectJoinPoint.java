package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Created by neerbans on 6/19/2017.
 */

@Aspect
public class EmployeeAspectJoinPoint {

    @Before("execution(public void aop.model..set*(*))")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Before running loggingAdvice on method="+joinPoint.toString());

        System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

    }

    //Advice arguments, will be applied to bean methods with single String argument
    @Before("args(name)")
    public void logStringArguments(String name){
        System.out.println("String argument passed="+name);
    }
}
