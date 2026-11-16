package com.example.lab.step1;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 1단계] 실행
public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        Member kim = new Member(1L, "김철수", Grade.VIP);
        System.out.println(orderService.createOrder(kim, "키보드", 50_000));

        // TODO [미션 1] 일반(BASIC) 회원을 만들어 같은 상품을 주문하고, 할인이 0원인지 확인하라
    }
}
