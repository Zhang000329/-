package com.zyj.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
// 将当前的对象创建维护交由spring容器维护
@Component
@Aspect // 将类标记为切面类
public class TimerAspect {
    @Around("execution(* com.zyj.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws  Throwable{
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start));
        return result;
    }
}
