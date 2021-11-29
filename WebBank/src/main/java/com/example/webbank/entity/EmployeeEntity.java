package com.example.webbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "Employee")
public class EmployeeEntity extends AbstractEntity {
    @Column
    private String position;
    @Column
    private int exp;
    @Column
    public float salary;
    @Column
    private String Cmt;
    @Column
    private String fullName;
    @Column
    private Date dateOfBirth;
    @Column
    private String address;
    @JsonIgnore
    @OneToOne(mappedBy = "employeeEntity",cascade = CascadeType.ALL)
    private AccountEntity entity;


}
