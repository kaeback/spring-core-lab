// [실습 4단계] 참고 코드 — 스프링 의존성이 없는 프로젝트라 컴파일하지 않는다 (src 밖에 둔다)
package com.example.lab.spring;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;
import org.springframework.stereotype.Service;

@Service                                  // "이 클래스를 빈으로 관리해 달라"
public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {   // 생성자 주입 — 스프링이 알맞은 빈을 넣는다
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
