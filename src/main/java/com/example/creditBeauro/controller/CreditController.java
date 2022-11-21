package com.example.creditBeauro.controller;

import com.example.creditBeauro.modal.CreditInquiryResponse;
import com.example.creditBeauro.service.CreditInquiryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditInquiryService creditInquiryService;

    public CreditController(CreditInquiryService creditInquiryService) {
        this.creditInquiryService = creditInquiryService;
    }

    @GetMapping(value = "/score/{pan}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreditInquiryResponse getScore(@PathParam("pan") String pan){
        return this.creditInquiryService.getScore(pan);
    }
}
