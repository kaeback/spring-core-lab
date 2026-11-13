package com.example.lab.step4.solution;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;
import com.example.lab.policy.LateFeePolicy;
import com.example.lab.step4.LoanService;

// [실습 4단계] 미션 4 해답 — 연체료 계산과 무관하게 LoanService의 흐름만 확인한다
public class FakePolicyApp {
    public static void main(String[] args) {
        LateFeePolicy fake = (member, book, overdueDays) -> 1_000;   // 람다로 즉석 구현
        LoanService loanService = new LoanService(fake);              // 가짜를 주입

        ReturnReceipt receipt = loanService.returnBook(
                new Member(1L, "tester", Grade.GENERAL), new Book("test", 10_000), 3);
        System.out.println(receipt);
        System.out.println(receipt.getLateFee() == 1_000 ? "확인 성공" : "확인 실패");
    }
}
