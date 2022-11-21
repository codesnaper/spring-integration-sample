package com.example.bank1.modal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class LoanInquiryResponse {

    private String name;

    private float interestRate;

    private Double principalAmount;

    private Double interestAmount;

    private Double totalPayment;

    private int year;
}
