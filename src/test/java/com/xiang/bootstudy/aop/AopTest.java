package com.xiang.bootstudy.aop;

import com.xiang.aop.security.CurrentUserHandler;
import com.xiang.aop.service.ProductService;
import com.xiang.bootstudy.BaseApplicationTests;
import org.junit.Test;

import javax.annotation.Resource;

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

    @Test
    public void deleteTest() {

        CurrentUserHandler.set("admin");
        productService.delete(1);
    }
}
