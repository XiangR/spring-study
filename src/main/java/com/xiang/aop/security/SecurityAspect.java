package com.xiang.aop.security;

import com.xiang.aop.entity.MessageKeyEnum;
import com.xiang.aop.entity.StateMachineContext;
import com.xiang.aop.service.AuthService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by xiangrui on 2018/6/25.
 *
 * @author xiangrui
 * @date 2018/6/25
 */
@Aspect
@Component
public class SecurityAspect {

    @Resource
    private AuthService authService;
    @Resource
    private ApplicationContext applicationContext;

    @Pointcut(value = "@annotation(com.xiang.aop.anno.AdminOnly)")
    public void adminOnly() {
    }

    @Pointcut(value = "@annotation(com.xiang.aop.anno.AddApplicationContext)")
    public void addApplicationContext() {
    }

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }

    @Before("addApplicationContext()")
    public void process(JoinPoint joinPoint) {

//         ((MethodInvocationProceedingJoinPoint) joinPoint).methodInvocation.getArguments()

        MethodInvocationProceedingJoinPoint joinPoint1 = (MethodInvocationProceedingJoinPoint) joinPoint;

        Object[] args1 = joinPoint1.getArgs();

        for (Object o : args1) {

            if (o instanceof StateMachineContext) {

                ((StateMachineContext) o).put(MessageKeyEnum.APPLICATION_CONTEXT, applicationContext);
            }
        }
    }

}
