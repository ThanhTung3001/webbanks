package com.example.webbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "Account")

public class AccountEntity extends AbstractEntity {
   @Column
    private String accountCode;
   @Column
    private float available;
   @Column
    private float reExport=50;
   @Column
    private float min=50;
    @OneToOne(mappedBy = "entity",cascade=CascadeType.ALL)
    private CostumerEntity costumerEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;
   @ManyToOne
   @JoinColumn(name = "role_id")
   private RoleAccount roleAccount;
}
