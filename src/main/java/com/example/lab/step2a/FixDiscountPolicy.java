package com.example.lab.step2a;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 1단계의 정책 — 이제 쓰지 않는다
public class FixDiscountPolicy {
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? 1_000 : 0;
    }
}
