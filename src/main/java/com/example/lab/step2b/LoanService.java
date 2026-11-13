package com.example.lab.step2b;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;

// [실습 2단계] 인터페이스를 도입했지만 구현체는 여전히 직접 new 한다
public class LoanService {
    // 선언 타입은 인터페이스지만...
    private final LateFeePolicy lateFeePolicy = new RateLateFeePolicy();  // ← 구현체를 직접 new
    // TODO [미션 2] 위 줄을 new DailyLateFeePolicy()로 바꿔 실행해 보라. 어느 파일을 고치게 되는가?

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
