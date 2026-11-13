package com.example.lab.step1;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;

// [실습 1단계] 대출 서비스 — 연체료 정책을 '직접' 생성해서 사용
public class LoanService {
    private final DailyLateFeePolicy lateFeePolicy = new DailyLateFeePolicy();  // ← 직접 new

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
