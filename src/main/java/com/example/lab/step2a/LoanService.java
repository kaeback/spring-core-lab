package com.example.lab.step2a;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;

// [실습 2단계] 정책을 바꾸려면 LoanService 안을 직접 고쳐야 한다
public class LoanService {
    // private final DailyLateFeePolicy lateFeePolicy = new DailyLateFeePolicy();
    private final RateLateFeePolicy lateFeePolicy = new RateLateFeePolicy();  // ← 여기를 수정

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
