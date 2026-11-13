package com.example.lab.step2a;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 새 정책 — 하루에 정가의 1%, 상한은 정가의 절반, 학생 회원은 절반
public class RateLateFeePolicy {
    public int lateFee(Member member, Book book, int overdueDays) {
        int fee = book.getPrice() / 100 * overdueDays;   // 하루에 정가의 1%
        fee = Math.min(fee, book.getPrice() / 2);         // 상한: 정가의 절반
        return member.getGrade() == Grade.STUDENT ? fee / 2 : fee;
    }
}
