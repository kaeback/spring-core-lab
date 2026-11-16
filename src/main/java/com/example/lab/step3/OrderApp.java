package com.example.lab.step3;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;

// [실습 3단계] 실행 — 어떤 정책을 쓸지는 호출하는 쪽이 정한다
public class OrderApp {
    public static void main(String[] args) {
        DiscountPolicy policy = new RateDiscountPolicy();      // ← 정책 선택은 여기서
        // TODO [미션 3] 할인을 하지 않는 NoDiscountPolicy를 만들어 이 줄에서만 바꿔 끼워라
        OrderService orderService = new OrderService(policy);

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
