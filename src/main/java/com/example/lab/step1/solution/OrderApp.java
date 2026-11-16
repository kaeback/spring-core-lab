package com.example.lab.step1.solution;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.step1.OrderService;

// [실습 1단계] 미션 1 해답 — VIP 회원과 일반 회원의 할인 비교
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));   // VIP: 1,000원 할인

        Member lee = new Member(2L, "이영희", Grade.BASIC);
        System.out.println(orderService.createOrder(lee, "키보드", 50_000));   // 일반: 할인 없음
    }
}
