package com.example.lab.step4;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;

// [실습 4단계] 3단계와 같다 — 생성자로 정책을 주입받는다
public class LoanService {
    private final LateFeePolicy lateFeePolicy;

    // 생성자로 외부에서 주입받는다 — 더 이상 new 하지 않는다
    public LoanService(LateFeePolicy lateFeePolicy) {
        this.lateFeePolicy = lateFeePolicy;
    }

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
