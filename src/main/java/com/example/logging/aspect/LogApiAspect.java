package com.example.logging.aspect;


import com.example.logging.annotation.LogApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogApiAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogApiAspect.class);

    @Around("@annotation(logApiResponse)")
    public Object logApiResponse(ProceedingJoinPoint joinPoint, LogApiResponse logApiResponse) throws Throwable {
        Object response = joinPoint.proceed();
        logger.info("[API RESPONSE] {} - {}", joinPoint.getSignature(), response);
        return response;
    }
}
