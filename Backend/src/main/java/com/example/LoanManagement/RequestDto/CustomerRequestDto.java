package com.example.LoanManagement.RequestDto;

public class CustomerRequestDto {

    private String name;
    private String email;
    private String address;
    private String phonenumber;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(String name, String email, String address, String phonenumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
