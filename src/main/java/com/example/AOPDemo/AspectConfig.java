package com.example.AOPDemo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Configuration
@Slf4j
public class AspectConfig {

    @Before(value = "execution(* com.example.AOPDemo..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("Executing {}, at time: {}, by user: {}", joinPoint, new Date(), request.getHeader("userId"));
    }

    @AfterThrowing(pointcut = "execution(* com.example.AOPDemo..* (..))", throwing = "ex")
    public void errorInterceptor(RuntimeException ex) {
        log.info( ex.getMessage());
    }
}
