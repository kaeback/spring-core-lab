package com.example.lab.step1;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;

// [실습 1단계] 실행
public class LoanApp {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        Book book = new Book("객체지향의 사실과 오해", 20_000);

        Member kim = new Member(1L, "김철수", Grade.GENERAL);
        System.out.println(loanService.returnBook(kim, book, 5));   // 5일 연체

        // TODO [미션 1] 학생 회원을 만들어 같은 책을 5일 늦게 반납하고, 연체료가 250원인지 확인하라
    }
}
