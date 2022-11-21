package com.example.bank1.service;

import com.example.bank1.modal.LoanInquiry;
import com.example.bank1.modal.LoanInquiryResponse;

public interface ILoanInquiryService {

    LoanInquiryResponse loanInquiry(LoanInquiry loanInquiry);

}
