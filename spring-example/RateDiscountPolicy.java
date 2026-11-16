// [실습 4단계] 참고 코드 — 스프링 의존성이 없는 프로젝트라 컴파일하지 않는다 (src 밖에 둔다)
package com.example.lab.spring;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.policy.DiscountPolicy;
import org.springframework.stereotype.Component;

@Component                                // 빈으로 등록될 구현체
public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * 10 / 100 : 0;
    }
}
