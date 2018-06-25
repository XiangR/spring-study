package com.xiang.aop.service;

import com.xiang.aop.anno.AdminOnly;
import com.xiang.aop.entity.Product;
import org.springframework.stereotype.Service;

/**
 * Created by xiangrui on 2018/6/25.
 *
 * @author xiangrui
 * @date 2018/6/25
 */
@Service
public class ProductService {

    @AdminOnly
    public void insert(Product product) {

        System.out.println("insert product");
    }

    @AdminOnly
    public void delete(int id) {

        System.out.println("insert product");
    }
}
