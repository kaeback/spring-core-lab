package com.example.lab.step2a;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 새 정책 — VIP는 주문 금액의 10% 할인
public class RateDiscountPolicy {
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * 10 / 100 : 0;
    }
}
