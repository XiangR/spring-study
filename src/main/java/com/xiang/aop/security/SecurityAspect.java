package com.xiang.aop.security;

import com.xiang.aop.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("@annotation(com.xiang.aop.anno.AdminOnly)")
    public void adminOnly() {
    }

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }

}
