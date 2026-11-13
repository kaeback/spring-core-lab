package com.example.lab;

import com.example.lab.domain.Book;
import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.step5b.AppConfig;
import com.example.lab.step5b.LoanService;
import com.example.lab.step5b.LoanServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 5단계: AppConfig가 내보내는 객체는 프록시이고, 계산 결과는 실제 객체와 같다
class ProxyTest {
    @Test
    void 프록시를_거쳐도_결과는_같다() {
        LoanService loanService = new AppConfig().loanService();
        assertTrue(Proxy.isProxyClass(loanService.getClass()));
        assertFalse(loanService instanceof LoanServiceImpl);

        int fee = loanService.returnBook(new Member(1L, "김철수", Grade.GENERAL),
                new Book("객체지향의 사실과 오해", 20_000), 5).getLateFee();
        assertEquals(1_000, fee);
    }
}
