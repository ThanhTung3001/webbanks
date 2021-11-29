package com.example.webbank.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RoleDto {
    private Long id;

    private Date createDate;

    private Date createBy;

    private String role;
}
