package com.example.LoanManagement.Service;

import com.example.LoanManagement.Entity.Customer;
import com.example.LoanManagement.Entity.Loan;
import com.example.LoanManagement.Enum.LoanStatus;
import com.example.LoanManagement.Repository.CustomerRepository;
import com.example.LoanManagement.Repository.LoanRepository;
import com.example.LoanManagement.RequestDto.LoanRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public String create(LoanRequestDto loan) {

        System.out.println("Loan service called...");

        // Validation
        if (loan.getAmount() == null || loan.getAmount() <= 0) {
            return "Loan amount must be greater than 0";
        }
        if (loan.getInterestRate() == null || loan.getInterestRate() < 0) {
            return "Interest rate must be non-negative";
        }

        // Get Customer
        Customer customer = customerRepository.findById(loan.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Credit score check
        if (customer.getCreditScore() < 550) {
            return "Credit score of customer must be at least 550";
        }

        try {
            // Create loan
            Loan loanEntity = new Loan();
            loanEntity.setLoanStatus(LoanStatus.Pending);
            loanEntity.setAmount(loan.getAmount());
            loanEntity.setInterestRate(loan.getInterestRate());
            loanEntity.setAppliedDate(LocalDate.now());
            loanEntity.setLoanType(loan.getLoanType());
            loanEntity.setCustomer(customer);

            // Save to DB
            Loan saved = loanRepository.save(loanEntity);

            return "Loan ID " + saved.getId() + " saved successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error creating loan: " + e.getMessage());
        }
    }

    public List<Loan> getloans() {
        try {
            return loanRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving loans: " + e.getMessage());
        }
    }

    public boolean updatestatus(Long loanId, LoanStatus status) {
        System.out.println("Loan service called...");

        try {
            Loan loanEntity = loanRepository.findById(loanId).orElse(null);

            if (loanEntity != null) {
                loanEntity.setLoanStatus(status);
                loanRepository.save(loanEntity);
                return true;
            }

            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error updating status: " + e.getMessage());
        }
    }
}
