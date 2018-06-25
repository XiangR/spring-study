package com.xiang.aop.service;

import com.xiang.aop.security.CurrentUserHandler;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by xiangrui on 2018/6/25.
 *
 * @author xiangrui
 * @date 2018/6/25
 */
@Component
public class AuthService {

    public void checkAccess() {
        String user = CurrentUserHandler.get();
        if (!Objects.equals(user, "admin")) {
            throw new RuntimeException("operation not allow");
        }
    }
}
