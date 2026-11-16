package com.example.lab.step2a;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;

// [실습 2단계] 정책을 바꾸려면 OrderService 안을 직접 고쳐야 한다
public class OrderService {
    // private final FixDiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();  // ← 여기를 수정

    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
