package com.example.lab.step3.solution;

import com.example.lab.domain.Member;
import com.example.lab.policy.DiscountPolicy;

// [실습 3단계] 미션 3 해답 — 할인을 하지 않는 기간에 쓰는 정책
public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
