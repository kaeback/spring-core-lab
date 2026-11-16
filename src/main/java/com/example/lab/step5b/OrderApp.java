package com.example.lab.step5b;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 5단계] 실행 — 받은 객체는 OrderServiceImpl이 아니라 프록시다
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new AppConfig().orderService();
        System.out.println("받은 객체: " + orderService.getClass().getSimpleName());

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
