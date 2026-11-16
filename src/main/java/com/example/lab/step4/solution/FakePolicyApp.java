package com.example.lab.step4.solution;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;
import com.example.lab.step4.OrderService;

// [실습 4단계] 미션 4 해답 — 할인 계산과 무관하게 OrderService의 흐름만 확인한다
public class FakePolicyApp {
    public static void main(String[] args) {
        DiscountPolicy fake = (member, price) -> 1_000;           // 람다로 즉석 구현
        OrderService orderService = new OrderService(fake);       // 가짜를 주입

        Order order = orderService.createOrder(new Member(1L, "tester", Grade.BASIC), "test", 10_000);
        System.out.println(order);
        System.out.println(order.payment() == 9_000 ? "확인 성공" : "확인 실패");
    }
}
