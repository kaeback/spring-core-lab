package com.example.lab.policy;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// VIP는 1,000원 정액 할인
public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? 1_000 : 0;
    }
}
