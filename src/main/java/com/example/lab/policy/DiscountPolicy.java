package com.example.lab.policy;

import com.example.lab.domain.Member;

// [실습 2단계] 할인 정책의 공통 인터페이스 — 2단계부터 끝까지 이 패키지를 쓴다
public interface DiscountPolicy {
    int discount(Member member, int price);
}
