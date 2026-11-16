package com.example.lab.step1;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;

// [실습 1단계] 주문 서비스 — 할인 정책을 '직접' 생성해서 사용
public class OrderService {
    private final FixDiscountPolicy discountPolicy = new FixDiscountPolicy();  // ← 직접 new

    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
