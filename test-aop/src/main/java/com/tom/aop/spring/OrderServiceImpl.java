package com.tom.aop.spring;

import org.springframework.stereotype.Service;

/**
 * Created by tom on 2016/5/5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public void save() {
        System.out.println("添加...");
    }
    @Override
    public Integer delete(Integer param) {
        System.out.println("删除...");
        return param;
    }
}
