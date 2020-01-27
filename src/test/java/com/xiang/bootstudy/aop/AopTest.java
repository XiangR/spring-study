package com.xiang.bootstudy.aop;

import com.alibaba.fastjson.JSON;
import com.xiang.aop.entity.StateMachineContext;
import com.xiang.aop.security.CurrentUserHandler;
import com.xiang.aop.service.ProductService;
import com.xiang.bootstudy.BaseApplicationTests;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.fail;

/**
 * Created by xiangrui on 2018/6/25.
 *
 * @author xiangrui
 * @date 2018/6/25
 */
public class AopTest extends BaseApplicationTests {

    @Resource
    private ProductService productService;

    @Test
    public void contextLoads() {
    }

    @Test(expected = Exception.class)
    public void insertTest() {
        CurrentUserHandler.set("tom");
        productService.delete(1);
    }


    @Test()
    public void doContext() {
        StateMachineContext context = new StateMachineContext();
        System.out.println(JSON.toJSON(context));
        productService.doContext(context);
        System.out.println(JSON.toJSON(context));
    }

    @Test
    public void insertTest2() {

        try {
            CurrentUserHandler.set("tom");
            productService.delete(1);
            fail("没有成功检测到 -> operation not allow");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().equals("operation not allow"));
        }
    }

    @Test
    public void deleteTest() {

        CurrentUserHandler.set("admin");
        productService.delete(1);
    }

}
