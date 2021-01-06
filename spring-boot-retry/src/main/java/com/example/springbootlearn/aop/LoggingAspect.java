package com.example.springbootlearn.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around(value = "execution(* com.example.springbootlearn.service..*(..)))")
    public Object profilerAllMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*
        Get Intercepted method details
         */
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        final StopWatch stopWatch = new StopWatch();
        /*
        Measure method execution
         */
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log.info("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

}
