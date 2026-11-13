package com.example.lab.step1;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 1단계] 연체료 정책 — 하루 100원 정액, 학생 회원은 하루 50원
public class DailyLateFeePolicy {
    public int lateFee(Member member, Book book, int overdueDays) {
        int perDay = member.getGrade() == Grade.STUDENT ? 50 : 100;
        return perDay * overdueDays;
    }
}
