package com.example.bank1.modal;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoanInquiry {

    private LoanType loanType;

    private String panNo;

    private CustomerDemographic customerDemographic;

    private int creditScore;

    private double amount;

    private int year;
}
