package com.example.lab.policy;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// 하루 100원 정액, 학생 회원은 하루 50원
public class DailyLateFeePolicy implements LateFeePolicy {
    @Override
    public int lateFee(Member member, Book book, int overdueDays) {
        int perDay = member.getGrade() == Grade.STUDENT ? 50 : 100;
        return perDay * overdueDays;
    }
}
