package com.example.LoanManagement.Service;

import com.example.LoanManagement.Entity.Customer;
import com.example.LoanManagement.Entity.Loan;
import com.example.LoanManagement.Repository.CustomerRepository;
import com.example.LoanManagement.RequestDto.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {


   @Autowired
   private CustomerRepository customerrepository;

    public String create(CustomerRequestDto customer) {
        if(Emailcheck(customer.getEmail())){
            return "Customer is already Exists please try with different mail";
        }
           if(Phonecheck(customer.getPhonenumber())){
            return "Customer is already Exists please try with different phone number";
        }

        try {
            Customer cus=new Customer();
            cus.setName(customer.getName());
            cus.setEmail(customer.getEmail());
            cus.setAddress(customer.getAddress());
            cus.setNumber(customer.getPhonenumber());
            Random random = new Random();
            Long randomValue = random.nextLong(1201 - 200) + 200;
            cus.setCreditScore(randomValue);
           Customer saved= customerrepository.save(cus);

           return saved.getName()+"created successfully";

        }
        catch (Exception e) {
             return "Customer Not created "+e.getMessage();
        }

    }

    private boolean Emailcheck(String email) {
        return customerrepository.findByEmail(email).isPresent();



    }
    private boolean Phonecheck(String phone) {
        return customerrepository.existsByNumber(phone);
    }
}
