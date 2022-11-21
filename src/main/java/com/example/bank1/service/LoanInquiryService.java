package com.example.bank1.service;

import com.example.bank1.modal.LoanInquiry;
import com.example.bank1.modal.LoanInquiryResponse;
import org.springframework.stereotype.Service;

@Service
public class LoanInquiryService implements ILoanInquiryService{

    public LoanInquiryResponse loanInquiry(LoanInquiry loanInquiry){
        LoanInquiryResponse loanInquiryResponse = new LoanInquiryResponse();
        switch (loanInquiry.getLoanType()){
            case CAR_LOAN:
                loanInquiryResponse.setInterestRate(getInterestRateOnCreditScore(loanInquiry) + 4);
                break;

            case HOME_LOAN:
                loanInquiryResponse.setInterestRate(getInterestRateOnCreditScore(loanInquiry));
                break;

            case PERSONAL_LOAN:
                loanInquiryResponse.setInterestRate(getInterestRateOnCreditScore(loanInquiry) + 8);
                break;
        }
        calculateInterestAmount(loanInquiry, loanInquiryResponse);
        loanInquiryResponse.setName(loanInquiry.getCustomerDemographic().getName());
        return loanInquiryResponse;
    }

    private int getInterestRateOnCreditScore(LoanInquiry loanInquiry){
        if(loanInquiry.getCreditScore() < 500){
            return 12;
        } else if(loanInquiry.getCreditScore() > 500 && loanInquiry.getCreditScore() < 710){
            return 9;
        } else if(loanInquiry.getCreditScore() > 710 && loanInquiry.getCreditScore() < 850) {
            return 7;
        } else {
            return 6;
        }
    }

    private void calculateInterestAmount(LoanInquiry loanInquiry, LoanInquiryResponse loanInquiryResponse){
        double interestAmount = (loanInquiry.getAmount() * loanInquiryResponse.getInterestRate() * loanInquiry.getYear() ) / 100;
        loanInquiryResponse.setInterestAmount(interestAmount);
        loanInquiryResponse.setPrincipalAmount(loanInquiry.getAmount());
        loanInquiryResponse.setTotalPayment(loanInquiry.getAmount() + interestAmount);
        loanInquiryResponse.setYear(loanInquiryResponse.getYear());
    }
}
