package com.example.lab.step2a;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 처음 정책 — 1단계와 같다 (하루 100원, 학생 50원)
public class DailyLateFeePolicy {
    public int lateFee(Member member, Book book, int overdueDays) {
        int perDay = member.getGrade() == Grade.STUDENT ? 50 : 100;
        return perDay * overdueDays;
    }
}
