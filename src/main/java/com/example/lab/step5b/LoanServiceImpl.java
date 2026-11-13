package com.example.lab.step5b;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;

// [실습 5단계] 핵심 로직만 남은 구현 — 시간 측정 코드가 한 줄도 없다
public class LoanServiceImpl implements LoanService {
    private final LateFeePolicy lateFeePolicy;

    public LoanServiceImpl(LateFeePolicy lateFeePolicy) {
        this.lateFeePolicy = lateFeePolicy;
    }

    @Override
    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
