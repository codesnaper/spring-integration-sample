package com.example.bank2.service;

import com.example.bank2.modal.LoanInquiryResponse;
import com.example.bank2.modal.LoanInquiry;

public interface ILoanInquiryService {

    LoanInquiryResponse loanInquiry(LoanInquiry loanInquiry);

}
