package com.example.lab.step5b.solution;

import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;
import com.example.lab.step5b.OrderService;
import com.example.lab.step5b.OrderServiceImpl;

import java.lang.reflect.Proxy;

// [실습 5단계] 미션 5 해답 — step5b.AppConfig에서 핸들러 한 줄만 바꿨다
public class AppConfig {
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public OrderService orderService() {
        OrderService target = new OrderServiceImpl(discountPolicy());
        return (OrderService) Proxy.newProxyInstance(
                OrderService.class.getClassLoader(),
                new Class[]{ OrderService.class },
                new LogTraceHandler(target));       // ← 바꾼 곳은 이 한 줄
    }
}
