package io.rooftop.kpi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LoggingAop {

    Logger log = LoggerFactory.getLogger(LoggingAop.class);

//    @Pointcut(value="execution(* io.rooftop.kpi.*.*.*(..))")
//    @Pointcut(value="execution(* io.rooftop.kpi.web.KpiController.*(..))")
//    @Pointcut(value="execution(* io.rooftop.kpi.web.*.*(..))")
    @Pointcut("execution(* io.rooftop.kpi.web.*.*(..)) || execution(* io.rooftop.kpi.api.*.*(..))")
    public void configPointcut() {

    }

    @Around("configPointcut()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        log.info("INVOKED : Class [" + className + "] / Method [" +  methodName + "]");
        Object object = joinPoint.proceed();
        log.info("RESPONSE : Class [" + className + "] / Method [" +  methodName + "]");
        return object;
    }

    @Around("configPointcut()")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Method [" + joinPoint.getSignature() + "] took " + (end-start) + " ms");
        return object;
    }

//    @Around("pointcut()")
//    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
//        ObjectMapper mapper = new ObjectMapper();
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().toString();
//        Object[] array = joinPoint.getArgs();
//        log.info("INVOKED : Class [" + className + "][" +  methodName + "][" + mapper.writeValueAsString(array) + "]");
//        Object object = joinPoint.proceed();
////        log.info("RESPONSE : Class [" + className + "][" +  methodName + "][" + mapper.writeValueAsString(object) + "]");
//        return object;
//    }
}
