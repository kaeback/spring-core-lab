// [실습 4단계] 참고 코드 — 스프링 의존성이 없는 프로젝트라 컴파일하지 않는다 (src 밖에 둔다)
package com.example.lab.spring;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;
import org.springframework.stereotype.Service;

@Service                                  // "이 클래스를 빈으로 관리해 달라"
public class LoanService {
    private final LateFeePolicy lateFeePolicy;

    public LoanService(LateFeePolicy lateFeePolicy) {   // 생성자 주입 — 스프링이 알맞은 빈을 넣는다
        this.lateFeePolicy = lateFeePolicy;
    }

    public ReturnReceipt returnBook(Member member, Book book, int overdueDays) {
        int fee = lateFeePolicy.lateFee(member, book, overdueDays);
        return new ReturnReceipt(member.getName(), book.getTitle(), overdueDays, fee);
    }
}
