package com.example.LoanManagement.Controller;

import com.example.LoanManagement.Entity.Customer;
import com.example.LoanManagement.Entity.Loan;
import com.example.LoanManagement.Enum.LoanStatus;
import com.example.LoanManagement.RequestDto.LoanRequestDto;
import com.example.LoanManagement.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<String> applyLoan(@RequestBody LoanRequestDto loan) {
//     System.out.println("loans--------------------------------- "+loan.getAmount()+" "+loan.getInterestRate()+" "+loan.getInterestRate());

        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.create(loan));
    }


    @GetMapping()
    public List<Loan> getLoans() {
        List<Loan> loans=loanService.getloans();
        return loans;
    }

    @PutMapping("/{loanId}/{status}")
    public boolean updateLoanStatus(@PathVariable Long loanId, @PathVariable LoanStatus status) {

//          System.out.println("oan constol");
     return loanService.updatestatus(loanId,status);
    }
}
