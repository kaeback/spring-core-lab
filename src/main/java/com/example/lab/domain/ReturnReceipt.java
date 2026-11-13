package com.example.lab.domain;

// 반납 결과 — 누가 어떤 책을 며칠 늦게 반납했고 연체료가 얼마인지
public class ReturnReceipt {
    private final String memberName;
    private final String bookTitle;
    private final int overdueDays;
    private final int lateFee;

    public ReturnReceipt(String memberName, String bookTitle, int overdueDays, int lateFee) {
        this.memberName = memberName;
        this.bookTitle = bookTitle;
        this.overdueDays = overdueDays;
        this.lateFee = lateFee;
    }

    public int getLateFee() { return lateFee; }

    @Override
    public String toString() {
        return "ReturnReceipt{member=" + memberName + ", book=" + bookTitle
                + ", overdueDays=" + overdueDays + ", lateFee=" + lateFee + "}";
    }
}
