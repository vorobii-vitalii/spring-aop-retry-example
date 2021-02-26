package com.example.retriesdemo.aspect;

import com.example.retriesdemo.exception.FileReadException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RetryReadAspect {

    @Value("${retry.read.num}")
    private Integer retryReadNum;

    @Pointcut("execution(* *.readContentByFileName(String))")
    public void readContentByFileNameMethod() {}

    @Around("readContentByFileNameMethod()")
    public Object retryFileRead(ProceedingJoinPoint pjp) throws Throwable {
        Object result;

        for (int i = 0; i < retryReadNum; i++) {
            try {
                result = pjp.proceed();
            }
            catch (FileReadException e) {
                log.error("Caught error, remaining times to retry {}", retryReadNum - i - 1);
                continue;
            }
            return result;
        }

        throw new FileReadException();
    }

}
