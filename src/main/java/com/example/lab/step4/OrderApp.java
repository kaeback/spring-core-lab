package com.example.lab.step4;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 4단계] 실행 — 완성된 객체를 AppConfig에서 받아 쓴다
public class OrderApp {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        OrderService orderService = config.orderService();   // 완성된 객체를 '받아' 쓴다

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
