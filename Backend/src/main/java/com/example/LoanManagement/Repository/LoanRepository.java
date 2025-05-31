package com.example.LoanManagement.Repository;


import com.example.LoanManagement.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
