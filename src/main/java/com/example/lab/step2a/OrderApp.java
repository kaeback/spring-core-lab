package com.example.lab.step2a;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 실행 — 정률 할인 확인
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Member kim = new Member(1L, "김철수", Grade.VIP);
        Member lee = new Member(2L, "이영희", Grade.BASIC);

        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
        System.out.println(orderService.createOrder(kim, "모니터", 300_000));
        System.out.println(orderService.createOrder(lee, "키보드", 50_000));
    }
}
