package com.example.lab.step5b;

import com.example.lab.domain.Book;
import com.example.lab.domain.Member;
import com.example.lab.domain.ReturnReceipt;

// [실습 5단계] 프록시를 씌우기 위해 LoanService를 인터페이스로 추출했다
public interface LoanService {
    ReturnReceipt returnBook(Member member, Book book, int overdueDays);
}
