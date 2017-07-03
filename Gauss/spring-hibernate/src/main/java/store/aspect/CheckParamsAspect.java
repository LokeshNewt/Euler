package store.aspect;

import exception.InvalidArgException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import params.QueryParams;
import shared.CheckParams;
import shared.Param;
import shared.constants.Constants;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by neerbans on 4/6/2017.
 */

@Aspect
public class CheckParamsAspect {

    @Before("@annotation(checkParams)")
    public void CheckParams(JoinPoint joinPoint, CheckParams checkParams) throws Throwable {

        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation[][] annotations = method.getParameterAnnotations();
        if (args != null) {
            for (int argIndex = 0; argIndex < args.length; argIndex++) {
                for (Annotation annotation : annotations[argIndex]) {
                    if (!(annotation instanceof Param))
                        continue;
                    Param requestParam = (Param) annotation;
                    if (Constants.QUERY_PARAMS.equalsIgnoreCase(requestParam.value())) {
                        QueryParams queryParams = (QueryParams) args[argIndex];
                        if (queryParams == null || queryParams.getDate() == null) {
                            throw new InvalidArgException("date in queryParams must not be null.");
                        }
                    }
                }
            }
        }
//        return joinPoint..proceed();
    }
}
