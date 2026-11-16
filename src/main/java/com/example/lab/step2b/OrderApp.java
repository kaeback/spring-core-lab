package com.example.lab.step2b;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 실행 — 인터페이스 도입 후에도 결과는 step2a와 같다
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
