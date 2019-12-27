package com.wlx.swagger.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* springboot aop
* */
@Aspect
@Component
public class ValidateManager {
    public ValidateManager(){
        System.out.println("qqqq");
    }

    @Pointcut("execution(* com.wlx.swagger.controller.*.*(..))")
    public void PointcutDeclaration() {}

    //前置通知,方法执行之前执行
    @Before("PointcutDeclaration()")
    public void BeforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("BeforeMethod  The method   "+ methodName +"   parameter is  "+ Arrays.asList(args));
        System.out.println("add before");
        System.out.println();
    }


   // @Around(value = "@annotation(gm)") //切面作用在注解上
    public Object validateGet(ProceedingJoinPoint joinPoint, GetMapping gm) throws Throwable {
        return doValidate(joinPoint);
    }

    private Object doValidate(ProceedingJoinPoint joinPoint) throws Throwable {
       /* Boolean hasSpringValidate = (Boolean)ContextHolder.getContextData(HasSpringValidateContextKey.class);
        if(hasSpringValidate==null || hasSpringValidate){
            return joinPoint.proceed();
        }*/

       // Validator validator = new ValidatorImpl()
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         Validator defaultValidator = factory.getValidator();
        // defaultValidator.
        Object[] args = joinPoint.getArgs();
        if(args==null||args.length==0){
            return joinPoint.proceed();
        }
        for(Object arg:args){
            Map<String, Object> jsonResult = new HashMap<>();
            jsonResult.put("status", "qqq");
            jsonResult.put("message", "你妹啊");
            jsonResult.put("result", null);
            return JSON.toJSONString(jsonResult);
        }
        return joinPoint.proceed();
    }


}
