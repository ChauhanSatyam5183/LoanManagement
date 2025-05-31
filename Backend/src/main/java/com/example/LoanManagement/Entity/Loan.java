package com.example.LoanManagement.Entity;

import com.example.LoanManagement.Enum.LoanStatus;
import com.example.LoanManagement.Enum.LoanType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Setter
@Getter
@Table(name="Loan")
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanType loanType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus loanStatus;


    @Column(nullable = false)
    private Double Amount;


    @Column(nullable = false)
    private Double InterestRate;


  @Column(nullable = false)
  private LocalDate AppliedDate;


    @ManyToOne
    @JoinColumn(name = "customer_id")

    private Customer customer;
}
