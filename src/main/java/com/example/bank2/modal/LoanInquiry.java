package com.example.bank2.modal;

import lombok.Data;

@Data
public class LoanInquiry {

    private String customerName;

    private String contact;

    private String pan;

    private int creditScore;

    private double amount;

    private int year;

    private LoanType loanType;
}
