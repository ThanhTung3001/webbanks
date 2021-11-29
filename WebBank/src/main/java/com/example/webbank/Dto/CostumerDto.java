package com.example.webbank.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter
public class CostumerDto {
    private Long id;

    private Date createDate;

    private Date createBy;

    private String cmnd;

    private String fullName;

    private Date dateOfBirth;

    private String address;

    private float interest;

    private AccountDto accountDtos;
}
