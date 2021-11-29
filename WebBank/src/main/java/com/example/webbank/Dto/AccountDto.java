package com.example.webbank.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class AccountDto {
    private Long id;

    private Date createDate;

    private Date createBy;

    private String accountCode;

    private float available;

    private float reExport=50;

    private float min=50;

    private RoleDto roles;
}
