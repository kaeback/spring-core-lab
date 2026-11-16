package com.example.lab.step3.solution;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.DiscountPolicy;
import com.example.lab.step3.OrderService;

// [실습 3단계] 미션 3 해답 — OrderService는 그대로 두고 정책만 바꿔 끼운다
public class OrderApp {
    public static void main(String[] args) {
        DiscountPolicy policy = new NoDiscountPolicy();        // ← 바꾼 곳은 이 한 줄
        OrderService orderService = new OrderService(policy);

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
