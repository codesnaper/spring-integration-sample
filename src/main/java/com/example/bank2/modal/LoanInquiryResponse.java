package com.example.bank2.modal;

import lombok.Data;

@Data
public class LoanInquiryResponse {

    private double interestAmount;

    private double principalAmount;

    private int year;

    private int interestRate;
}
