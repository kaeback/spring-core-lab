package com.example.lab;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.FixDiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 교안의 실행 결과에 나오는 할인 금액을 확인한다
class DiscountPolicyTest {
    private final Member vip = new Member(1L, "김철수", Grade.VIP);
    private final Member basic = new Member(2L, "이영희", Grade.BASIC);

    @Test
    void 정액_할인() {
        DiscountPolicy policy = new FixDiscountPolicy();
        assertEquals(1_000, policy.discount(vip, 50_000));
        assertEquals(0, policy.discount(basic, 50_000));
    }

    @Test
    void 정률_할인() {
        DiscountPolicy policy = new RateDiscountPolicy();
        assertEquals(5_000, policy.discount(vip, 50_000));
        assertEquals(30_000, policy.discount(vip, 300_000));
        assertEquals(0, policy.discount(basic, 50_000));
    }
}
