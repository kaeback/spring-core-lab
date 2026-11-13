package com.example.lab.step5b.solution;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// [실습 5단계] 미션 5 해답 — 메서드 호출 전후에 시작과 끝을 출력한다
public class LogTraceHandler implements InvocationHandler {
    private final Object target;

    public LogTraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=== " + method.getName() + " 시작 ===");
        try {
            return method.invoke(target, args);
        } finally {
            System.out.println("=== " + method.getName() + " 끝 ===");
        }
    }
}
