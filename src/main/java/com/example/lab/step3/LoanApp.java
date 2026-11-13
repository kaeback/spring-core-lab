package com.example.lab.step3;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;

// [실습 3단계] 실행 — 어떤 정책을 쓸지는 호출하는 쪽이 정한다
public class LoanApp {
    public static void main(String[] args) {
        LateFeePolicy policy = new RateLateFeePolicy();      // ← 정책 선택은 여기서
        // TODO [미션 3] 연체료를 받지 않는 NoLateFeePolicy를 만들어 이 줄에서만 바꿔 끼워라
        LoanService loanService = new LoanService(policy);

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        Book book = new Book("객체지향의 사실과 오해", 20_000);
        System.out.println(loanService.returnBook(kim, book, 5));
    }
}
