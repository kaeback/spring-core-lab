package com.example.lab.policy;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;

// [실습 2단계] 연체료 정책의 공통 인터페이스 — 2단계부터 끝까지 이 패키지를 쓴다
public interface LateFeePolicy {
    int lateFee(Member member, Book book, int overdueDays);
}
