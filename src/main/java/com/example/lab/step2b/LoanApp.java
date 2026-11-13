package com.example.lab.step2b;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 2단계] 실행 — 인터페이스 도입 후에도 결과는 step2a와 같다
public class LoanApp {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        Book book = new Book("객체지향의 사실과 오해", 20_000);
        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        Member lee = new Member(2L, "이영희", Grade.STUDENT);

        System.out.println(loanService.returnBook(kim, book, 5));
        System.out.println(loanService.returnBook(kim, book, 60));
        System.out.println(loanService.returnBook(lee, book, 5));
    }
}
