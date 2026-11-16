package com.example.lab.step5a;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;

// [실습 5단계] 순진한 방법 — 시간 측정 코드를 메서드 안에 직접 넣었다
public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Member member, String itemName, int itemPrice) {
        long start = System.currentTimeMillis();          // ← 공통 코드
        try {
            int discountPrice = discountPolicy.discount(member, itemPrice);          // ← 핵심 로직
            return new Order(member.getName(), itemName, itemPrice, discountPrice);
        } finally {
            long end = System.currentTimeMillis();        // ← 공통 코드
            System.out.println("createOrder " + (end - start) + "ms");
        }
    }
}
