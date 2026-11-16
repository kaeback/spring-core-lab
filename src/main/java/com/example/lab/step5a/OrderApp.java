package com.example.lab.step5a;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 5단계] 실행 — 순진한 방법
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new AppConfig().orderService();

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
