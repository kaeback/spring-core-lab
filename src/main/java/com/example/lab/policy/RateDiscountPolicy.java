package com.example.lab.policy;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// VIP는 주문 금액의 10% 할인
public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * 10 / 100 : 0;
    }
}
