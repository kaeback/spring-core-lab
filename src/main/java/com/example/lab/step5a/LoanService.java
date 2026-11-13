package com.example.lab.step5a;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;

// [실습 5단계] 순진한 방법 — 시간 측정 코드를 메서드 안에 직접 넣었다
public class LoanService {
    private final LateFeePolicy lateFeePolicy;

    public LoanService(LateFeePolicy lateFeePolicy) {
        this.lateFeePolicy = lateFeePolicy;
    }

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        long start = System.currentTimeMillis();          // ← 공통 코드
        try {
            int fee = lateFeePolicy.lateFee(member, book, overdueDays);   // ← 핵심 로직
            return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
        } finally {
            long end = System.currentTimeMillis();        // ← 공통 코드
            System.out.println("returnBook " + (end - start) + "ms");
        }
    }
}
