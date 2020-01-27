package com.xiang.aop.entity;

import org.springframework.context.ApplicationContext;

/**
 * StateMachineContext 信息枚举
 */
public enum MessageKeyEnum {

    // region common
    /**
     * 入口处会统一置入
     */
    APPLICATION_CONTEXT("spring容器", ApplicationContext.class),

    // endregion


    ;
    private String desc;

    private Class msgClass;

    MessageKeyEnum(String desc, Class clazz) {
        this.desc = desc;
        this.msgClass = clazz;
    }

    public String getDesc() {
        return desc;
    }

    public Class getMsgClass() {
        return msgClass;
    }
}