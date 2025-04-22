package com.masterannonce.annoncebacksprintboot.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {


    @Before("execution(* com.masterannonce.annoncebacksprintboot.services.impls.AnnonceImpl.*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Méthode exécutée : " + joinPoint.getSignature());
    }
}
