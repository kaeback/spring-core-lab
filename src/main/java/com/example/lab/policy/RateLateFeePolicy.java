package com.example.lab.policy;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// 하루에 정가의 1%, 상한은 정가의 절반, 학생 회원은 절반
public class RateLateFeePolicy implements LateFeePolicy {
    @Override
    public int lateFee(Member member, Book book, int overdueDays) {
        int fee = book.getPrice() / 100 * overdueDays;
        fee = Math.min(fee, book.getPrice() / 2);
        return member.getGrade() == Grade.STUDENT ? fee / 2 : fee;
    }
}
