package com.example.lab.step5a;

import com.example.lab.policy.LateFeePolicy;
import com.example.lab.policy.RateLateFeePolicy;

// [실습 5단계] 4단계와 같은 조립 클래스
public class AppConfig {
    public LateFeePolicy lateFeePolicy() {
        return new RateLateFeePolicy();
    }

    public LoanService loanService() {
        return new LoanService(lateFeePolicy());
    }
}
