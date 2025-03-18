package com.nishintGoyal.AOP.AOP.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2
{
    @Before("allServiceMethodsPointCut()")
    public void beforeServiceMethodCalls(JoinPoint joinPoint)
    {
    log.info("Before advice method call LoggingAspectV2 , {}",joinPoint.getSignature());
    }

//    @After("allServiceMethodsPointCut()")
//    public void afterServiceMethodCalls(JoinPoint joinPoint)
//    {
//        log.info("After advice method call LoggingAspectV2 , {}",joinPoint.getSignature());
//    }

    @AfterReturning(value = "allServiceMethodsPointCut()",returning ="returnedObj")
    public void afterServiceMethodCalls(JoinPoint joinPoint,Object returnedObj)
    {
        log.info("After Return advice method call LoggingAspectV2 , {}",joinPoint.getSignature());
        log.info("After returning returned value, {}", returnedObj);
    }

    // AfterThrowing exception ke badh bhi chlega..

    @Pointcut(" execution ( * com.nishintGoyal.AOP.AOP.services.impl.*.* (..) ) ")
    public void allServiceMethodsPointCut()
    {

    }
}
