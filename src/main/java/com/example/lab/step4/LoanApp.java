package com.example.lab.step4;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 4단계] 실행 — 완성된 객체를 AppConfig에서 받아 쓴다
public class LoanApp {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        LoanService loanService = config.loanService();   // 완성된 객체를 '받아' 쓴다

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        Book book = new Book("객체지향의 사실과 오해", 20_000);
        System.out.println(loanService.returnBook(kim, book, 5));
    }
}
