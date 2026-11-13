package com.example.lab.step5b.solution;

import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;
import com.example.lab.step5b.LoanService;
import com.example.lab.step5b.LoanServiceImpl;

import java.lang.reflect.Proxy;

// [실습 5단계] 미션 5 해답 — step5b.AppConfig에서 핸들러 한 줄만 바꿨다
public class AppConfig {
    public LateFeePolicy lateFeePolicy() {
        return new RateLateFeePolicy();
    }

    public LoanService loanService() {
        LoanService target = new LoanServiceImpl(lateFeePolicy());
        return (LoanService) Proxy.newProxyInstance(
                LoanService.class.getClassLoader(),
                new Class[]{ LoanService.class },
                new LogTraceHandler(target));       // ← 바꾼 곳은 이 한 줄
    }
}
