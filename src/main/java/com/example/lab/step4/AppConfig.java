package com.example.lab.step4;

import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;

// [실습 4단계] 객체를 만들고 연결하는 일만 맡는 조립 클래스 — 직접 만든 작은 IoC 컨테이너
public class AppConfig {
    // "어떤 구현체를 쓸지" 결정은 전부 여기 모인다
    public LateFeePolicy lateFeePolicy() {
        return new RateLateFeePolicy();      // ← 정책 교체는 '이 한 줄' (TODO [미션 4])
    }

    public LoanService loanService() {
        return new LoanService(lateFeePolicy());   // 의존성을 조립해서 완성품을 반환
    }
}
