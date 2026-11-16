package com.example.lab.step5b;

import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;

import java.lang.reflect.Proxy;

// [실습 5단계] 실제 객체 대신 프록시로 감싼 객체를 내보낸다
public class AppConfig {
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public OrderService orderService() {
        OrderService target = new OrderServiceImpl(discountPolicy());
        // 시간 측정 기능으로 감싼 프록시를 반환
        return (OrderService) Proxy.newProxyInstance(
                OrderService.class.getClassLoader(),
                new Class[]{ OrderService.class },
                new TimeTraceHandler(target));      // TODO [미션 5] 다른 핸들러로 바꿔 끼워 보기
    }
}
