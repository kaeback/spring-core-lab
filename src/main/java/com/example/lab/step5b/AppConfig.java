package com.example.lab.step5b;

import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;

import java.lang.reflect.Proxy;

// [실습 5단계] 실제 객체 대신 프록시로 감싼 객체를 내보낸다
public class AppConfig {
    public LateFeePolicy lateFeePolicy() {
        return new RateLateFeePolicy();
    }

    public LoanService loanService() {
        LoanService target = new LoanServiceImpl(lateFeePolicy());
        // 시간 측정 기능으로 감싼 프록시를 반환
        return (LoanService) Proxy.newProxyInstance(
                LoanService.class.getClassLoader(),
                new Class[]{ LoanService.class },
                new TimeTraceHandler(target));      // TODO [미션 5] 다른 핸들러로 바꿔 끼워 보기
    }
}
