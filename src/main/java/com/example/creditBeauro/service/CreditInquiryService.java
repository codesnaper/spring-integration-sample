package com.example.creditBeauro.service;

import com.example.creditBeauro.modal.CreditInquiryResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditInquiryService {

    public CreditInquiryResponse getScore(String pan){
        CreditInquiryResponse creditInquiryResponse = new CreditInquiryResponse();
        creditInquiryResponse.setScore(pan.hashCode() % 1000);
        creditInquiryResponse.setPan(pan);
        return creditInquiryResponse;
    }
}
