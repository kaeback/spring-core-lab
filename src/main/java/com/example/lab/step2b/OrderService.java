package com.example.lab.step2b;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;
import com.example.lab.policy.DiscountPolicy;
import com.example.lab.policy.RateDiscountPolicy;

// [실습 2단계] 인터페이스를 도입했지만 구현체는 여전히 직접 new 한다
public class OrderService {
    // 선언 타입은 인터페이스지만...
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // ← 구현체를 직접 new
    // TODO [미션 2] 위 줄을 new FixDiscountPolicy()로 바꿔 실행해 보라. 어느 파일을 고치게 되는가?

    public Order createOrder(Member member, String itemName, int itemPrice) {
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getName(), itemName, itemPrice, discountPrice);
    }
}
