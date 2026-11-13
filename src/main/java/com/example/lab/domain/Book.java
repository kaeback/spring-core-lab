package com.example.lab.domain;

// 책 — 연체료 정책에 따라 정가(price)를 쓰기도 한다
public class Book {
    private final String title;
    private final int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() { return title; }
    public int getPrice()    { return price; }
}
