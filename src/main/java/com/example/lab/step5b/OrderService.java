package com.example.lab.step5b;

import com.example.lab.domain.Member;
import com.example.lab.domain.Order;

// [실습 5단계] 프록시를 씌우기 위해 OrderService를 인터페이스로 추출했다
public interface OrderService {
    Order createOrder(Member member, String itemName, int itemPrice);
}
