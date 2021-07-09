package com.example.myblog.aspect;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* myblog.web.*.*(..))")
    public  void  log(){

    }
    @Before("log()")
    public void doBefore(){
        logger.info("------doBefore------");
    }
    @After("log()")
    public void doAfter(){
        logger.info("------doBefore------");
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAferRuturn(Object result){
        logger.info("Rrsult : {}"+result);
    }
}
