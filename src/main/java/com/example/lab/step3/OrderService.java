package com.example.lab.step3;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;

// [실습 3단계] DI — 사용할 정책을 생성자로 외부에서 받는다
public class OrderService {
    private final DiscountPolicy discountPolicy;

    // 생성자로 외부에서 주입받는다 — 더 이상 new 하지 않는다
    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
