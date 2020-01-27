package com.xiang.aop.entity;

import com.alibaba.fastjson.JSON;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author guankaiqiang
 */
public class StateMachineContext {

    private Map<MessageKeyEnum, Object> messages = new HashMap<>();


    @SuppressWarnings("unchecked")
    public <T> T get(MessageKeyEnum key) {
        if (messages == null || key == null) {
            return null;
        }
        Object value = messages.get(key);
        if (value == null) {
            return null;
        }
        if (!key.getMsgClass().isAssignableFrom(value.getClass())) {
            throw new IllegalArgumentException("Incorrect type specified for header '" +
                    key + "'. Expected [" + key.getMsgClass() + "] but actual type is [" + value.getClass() + "]");
        }
        return (T) value;
    }

    public int size() {
        return messages.size();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public boolean containsKey(MessageKeyEnum key) {
        return messages.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return messages.containsValue(value);
    }

    public <T> T put(MessageKeyEnum key, Object value) {
        if (messages == null || key == null) {
            return null;
        }
        if (value == null) {
            return null;
        }
        if (!key.getMsgClass().isAssignableFrom(value.getClass())) {
            throw new IllegalArgumentException("Incorrect type specified for header '" +
                    key + "'. Expected [" + key.getMsgClass() + "] but actual type is [" + value.getClass() + "]");
        }
        return (T) messages.put(key, value);
    }

    public <T> T remove(MessageKeyEnum key) {
        if (messages == null || key == null) {
            return null;
        }
        return (T) messages.remove(key);
    }

    public void putAll(Map<? extends MessageKeyEnum, ?> m) {
        messages.putAll(m);
    }

    public void clear() {
        messages.clear();
    }

    public Set<MessageKeyEnum> keySet() {
        return messages.keySet();
    }

    public Collection<Object> values() {
        return messages.values();
    }

    public Set<Map.Entry<MessageKeyEnum, Object>> entrySet() {
        return messages.entrySet();
    }

}
