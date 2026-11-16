package com.example.lab.step5a;

import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;

// [실습 5단계] 4단계와 같은 조립 클래스
public class AppConfig {
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public OrderService orderService() {
        return new OrderService(discountPolicy());
    }
}
