package com.example.lab.step5b;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;

// [실습 5단계] 핵심 로직만 남은 구현 — 시간 측정 코드가 한 줄도 없다
public class OrderServiceImpl implements OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
