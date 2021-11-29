package com.example.webbank.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EmployeeDto {
    private  Long id;
    private String position;
    private String fullName;
    private Date dataOfbirth;
    private String address;
    private float salary;
    private float Available;
    private String Role;
    private String bankCode;
    private int Expr;
    private String cmnd;

}
