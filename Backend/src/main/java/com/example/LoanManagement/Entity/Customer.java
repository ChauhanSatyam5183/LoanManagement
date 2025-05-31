package com.example.LoanManagement.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Table(name="Customer")
@AllArgsConstructor
@NoArgsConstructor

public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @Column(nullable = false)
    private String Name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String Address;


    @Column(nullable = false,unique = true)
    private String number;



    @Column(nullable = false)
    private Long CreditScore;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Loan> loans;

}
