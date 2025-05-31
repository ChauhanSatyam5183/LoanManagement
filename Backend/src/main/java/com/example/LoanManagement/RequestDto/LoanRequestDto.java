package com.example.LoanManagement.RequestDto;

import com.example.LoanManagement.Enum.LoanType;

public class LoanRequestDto {

    private LoanType loanType;
    private Double Amount;
    private Double InterestRate;
    private Long customerId;

    public LoanRequestDto() {
    }

    public LoanRequestDto(LoanType loanType, Double Amount, Double InterestRate, Long customerId) {
        this.loanType = loanType;
        this.Amount = Amount;
        this.InterestRate = InterestRate;
        this.customerId = customerId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        this.Amount = amount;
    }

    public Double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.InterestRate = interestRate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
