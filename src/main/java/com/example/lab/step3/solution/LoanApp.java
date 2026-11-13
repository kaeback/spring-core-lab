package com.example.lab.step3.solution;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.LateFeePolicy;
import com.example.lab.step3.LoanService;

// [실습 3단계] 미션 3 해답 — LoanService는 그대로 두고 정책만 바꿔 끼운다
public class LoanApp {
    public static void main(String[] args) {
        LateFeePolicy policy = new NoLateFeePolicy();        // ← 바꾼 곳은 이 한 줄
        LoanService loanService = new LoanService(policy);

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        Book book = new Book("객체지향의 사실과 오해", 20_000);
        System.out.println(loanService.returnBook(kim, book, 5));
    }
}
