package com.example.bank1.controller;

import com.example.bank1.service.ILoanInquiryService;
import com.example.bank1.modal.LoanInquiry;
import com.example.bank1.modal.LoanInquiryResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bank1/loan")
public class LoanController {

    private final ILoanInquiryService loanInquiryService;

    public LoanController(ILoanInquiryService loanInquiryService) {
        this.loanInquiryService = loanInquiryService;
    }

    @PostMapping(value = "/inquiry" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanInquiryResponse loanInquiry(@RequestBody LoanInquiry loanInquiry){
        return this.loanInquiryService.loanInquiry(loanInquiry);
    }
}
