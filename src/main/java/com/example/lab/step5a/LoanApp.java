package com.example.lab.step5a;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 5단계] 실행 — 순진한 방법
public class LoanApp {
    public static void main(String[] args) {
        LoanService loanService = new AppConfig().loanService();

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        Book book = new Book("객체지향의 사실과 오해", 20_000);
        System.out.println(loanService.returnBook(kim, book, 5));
    }
}
