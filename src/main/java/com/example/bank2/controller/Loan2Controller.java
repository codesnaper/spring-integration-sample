package com.example.bank2.controller;

import com.example.bank2.modal.LoanInquiryResponse;
import com.example.bank2.service.ILoanInquiryService;
import com.example.bank2.modal.LoanInquiry;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bank2/loan")
public class Loan2Controller {

    private final ILoanInquiryService loanInquiryService;

    public Loan2Controller(ILoanInquiryService loanInquiryService) {
        this.loanInquiryService = loanInquiryService;
    }

    @PostMapping(value = "/inquiry" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanInquiryResponse loanInquiry(@RequestBody LoanInquiry loanInquiry){
        return this.loanInquiryService.loanInquiry(loanInquiry);
    }
}
