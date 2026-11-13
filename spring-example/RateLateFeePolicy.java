// [실습 4단계] 참고 코드 — 스프링 의존성이 없는 프로젝트라 컴파일하지 않는다 (src 밖에 둔다)
package com.example.lab.spring;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.LateFeePolicy;
import org.springframework.stereotype.Component;

@Component                                // 빈으로 등록될 구현체
public class RateLateFeePolicy implements LateFeePolicy {
    @Override
    public int lateFee(Member member, Book book, int overdueDays) {
        int fee = book.getPrice() / 100 * overdueDays;
        fee = Math.min(fee, book.getPrice() / 2);
        return member.getGrade() == Grade.STUDENT ? fee / 2 : fee;
    }
}
