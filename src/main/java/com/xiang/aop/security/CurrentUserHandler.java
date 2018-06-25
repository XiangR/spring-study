package com.xiang.aop.security;

/**
 * Created by xiangrui on 2018/6/25.
 *
 * @author xiangrui
 * @date 2018/6/25
 */
public class CurrentUserHandler {

    private static final ThreadLocal<String> handler = new InheritableThreadLocal<>();

    public static String get() {
        return handler.get() == null ? "unknown" : handler.get();
    }

    public static void set(String user) {
        handler.set(user);
    }

}
