package com.example.LoanManagement.Controller;


import com.example.LoanManagement.Entity.Customer;
import com.example.LoanManagement.RequestDto.CustomerRequestDto;
import com.example.LoanManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerservice;


    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequestDto customer) {

         System.out.println("hello"+customer.getPhonenumber()+" "+customer.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(customerservice.create(customer));
    }
}
