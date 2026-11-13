package com.example.lab;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.DailyLateFeePolicy;
import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 교안의 실행 결과에 나오는 연체료 금액을 확인한다
class LateFeePolicyTest {
    private final Member general = new Member(1L, "김철수", Grade.GENERAL);
    private final Member student = new Member(2L, "이영희", Grade.STUDENT);
    private final Book book = new Book("객체지향의 사실과 오해", 20_000);

    @Test
    void 하루_정액_정책() {
        LateFeePolicy policy = new DailyLateFeePolicy();
        assertEquals(500, policy.lateFee(general, book, 5));
        assertEquals(250, policy.lateFee(student, book, 5));
    }

    @Test
    void 정률_정책과_상한() {
        LateFeePolicy policy = new RateLateFeePolicy();
        assertEquals(1_000, policy.lateFee(general, book, 5));
        assertEquals(10_000, policy.lateFee(general, book, 60));   // 상한: 정가의 절반
        assertEquals(500, policy.lateFee(student, book, 5));
    }
}
