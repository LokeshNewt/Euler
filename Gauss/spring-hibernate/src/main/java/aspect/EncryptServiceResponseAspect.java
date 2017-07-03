package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class EncryptServiceResponseAspect {


    private static final String ENCRYPT_NONE = "None";
    private static final String ENCRYPT_DEFAULT = "Default";
    private static final String ENCRYPT_USERID = "UserId";
    private static final String ENCRYPT_SESSION = "Session";
    private static final String ENCRYPT_LEVEL = "encryptLevel";

    @AfterReturning(value = "@annotation(encryptResponse)", returning = "returnValue")
    public void EncryptResponse(JoinPoint point,Object returnValue, EncryptResponse encryptResponse) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Class methodSignatureReturnType = methodSignature.getReturnType();
        if (methodSignatureReturnType.getName().equals("com.edifecs.ehie.service.response.IServiceResponse"))
            if (returnValue != null)
                ;
                //encryptServiceResponse((IServiceResponse<?>) returnValue);
    }

}
