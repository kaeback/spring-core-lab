package com.example.lab.step5b.solution;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.step5b.OrderService;

// [실습 5단계] 미션 5 해답 실행
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new AppConfig().orderService();

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));
    }
}
