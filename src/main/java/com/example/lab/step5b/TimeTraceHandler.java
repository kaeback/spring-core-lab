package com.example.lab.step5b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// [실습 5단계] 공통 관심사(시간 측정)를 한 곳에 모은다
public class TimeTraceHandler implements InvocationHandler {
    private final Object target;                       // 실제 객체

    public TimeTraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return method.invoke(target, args);        // ← 핵심 로직은 실제 객체에 맡긴다
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(method.getName() + " " + (end - start) + "ms");
        }
    }
}
