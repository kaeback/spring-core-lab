package com.example.lab.step3.solution;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.policy.LateFeePolicy;

// [실습 3단계] 미션 3 해답 — 연체료 면제 기간에 쓰는 정책
public class NoLateFeePolicy implements LateFeePolicy {
    @Override
    public int lateFee(Member member, Book book, int overdueDays) {
        return 0;
    }
}
