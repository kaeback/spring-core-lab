package com.example.lab;

import com.example.lab.domain.Grade;
import com.example.lab.domain.Member;
import com.example.lab.step5b.AppConfig;
import com.example.lab.step5b.OrderService;
import com.example.lab.step5b.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 5단계: AppConfig가 내보내는 객체는 프록시이고, 계산 결과는 실제 객체와 같다
class ProxyTest {
    @Test
    void 프록시를_거쳐도_결과는_같다() {
        OrderService orderService = new AppConfig().orderService();
        assertTrue(Proxy.isProxyClass(orderService.getClass()));
        assertFalse(orderService instanceof OrderServiceImpl);

        int discount = orderService.createOrder(new Member(1L, "김철수", Grade.VIP), "키보드", 50_000)
                .getDiscountPrice();
        assertEquals(5_000, discount);
    }
}
