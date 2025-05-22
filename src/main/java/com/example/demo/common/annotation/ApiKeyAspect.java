package com.example.demo.common.annotation;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.example.demo.exception.ApiKeyException;

@Aspect
@Component
public class ApiKeyAspect {

    @Value("${app.api-key}")
    private String validApiKey;

    @Pointcut("@annotation(com.example.demo.common.annotation.RequiredApiKey) || @within(com.example.demo.common.annotation.RequiredApiKey)")
    public void requireApiKeyPointcut() {}

    @Before("requireApiKeyPointcut()")
    public void checkApiKey(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String apiKey = request.getHeader("X-API-KEY");

        if (apiKey == null || !apiKey.equals(validApiKey)) {
            throw new ApiKeyException("Invalid or missing API key");
        }
    }
}
