package com.example.lab.step4;

import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;

// [실습 4단계] 객체를 만들고 연결하는 일만 맡는 조립 클래스 — 직접 만든 작은 IoC 컨테이너
public class AppConfig {
    // "어떤 구현체를 쓸지" 결정은 전부 여기 모인다
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();      // ← 정책 교체는 '이 한 줄' (TODO [미션 4])
    }

    public OrderService orderService() {
        return new OrderService(discountPolicy());   // 의존성을 조립해서 완성품을 반환
    }
}
