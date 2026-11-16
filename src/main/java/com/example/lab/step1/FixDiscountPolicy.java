package com.example.lab.step1;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 1단계] 할인 정책 — VIP는 1,000원 정액 할인
public class FixDiscountPolicy {
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? 1_000 : 0;
    }
}
