package com.nishintGoyal.AOP.AOP.aspects;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect
{
    //@Before("execution(* orderPackage(..))")
    @Before("    execution( *  com.nishintGoyal.AOP.AOP.services.impl.HelicopterServiceImpl.orderPackage(..))  ")
    public void beforeOrderPackage(JoinPoint joinPoint)
    {
        log.info("Before orderPackage called from LoggingAspect kind, {}",joinPoint.getKind());
        log.info("Before called from LoggingAspect sign, {}",joinPoint.getSignature());
    }

    @Before("within(com.nishintGoyal.AOP.AOP.services.impl.HelicopterServiceImpl)")
    public void beforeServiceImplCall(JoinPoint joinPoint)
    {
        log.info("Service Impl call detected in method: {}", joinPoint.getSignature());
    }

    @Before( "@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransAnnotCall()
    {
        log.info("Calling this before transactional annot");
    }

    @Before( "@annotation( com.nishintGoyal.AOP.AOP.aspects.MyLogging )")
    public void beforeLoggingAnnotCall()
    {
        log.info("Calling this before annot");
    }

    @After("ownPointCut()")
    public void afterMyLoggingPointCut()
    {
        log.info("After My Logging Annotation calls");
    }

    @Pointcut("@annotation(com.nishintGoyal.AOP.AOP.aspects.MyLogging)")
    public void ownPointCut()
    {

    }

}
