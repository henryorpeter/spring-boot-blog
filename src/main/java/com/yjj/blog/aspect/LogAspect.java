package com.yjj.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/11
 * \* Time: 21:15
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.yjj.blog.web.*.*(..))")
    public void log(){};

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequstLog requstLog = new RequstLog(url,ip,classMethod,args);
        logger.info("Reqeust: {}",requstLog);
    }

    @After("log()")
    public void doAfter(){
        logger.info("---------doAfter---------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterRuturn(Object result){
        logger.info("Result : {}",result);
    }

    public class RequstLog{
        private String url;
        private String id;
        private String classMethod;
        private Object[] args;

        public RequstLog(String url, String id, String classMethod, Object[] args) {
            this.url = url;
            this.id = id;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequstLog{" +
                    "url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}