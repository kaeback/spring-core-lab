package com.example.lab.step1.solution;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.step1.LoanService;

// [실습 1단계] 미션 1 해답 — 일반 회원과 학생 회원의 연체료 비교
public class LoanApp {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        Book book = new Book("객체지향의 사실과 오해", 20_000);

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        System.out.println(loanService.returnBook(kim, book, 5));   // 5일 × 100원

        Member lee = new Member(2L, "이영희", Grade.STUDENT);
        System.out.println(loanService.returnBook(lee, book, 5));   // 5일 × 50원
    }
}
