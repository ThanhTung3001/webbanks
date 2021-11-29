package com.example.webbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "costumer")
public class CostumerEntity extends AbstractEntity{
    @Column
    private String cmnd;
    @Column
    private String fullName;
    @Column
    private Date dateOfBirth;
    @Column
    private String address;
    @Column
    private float interest= 0.5f;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountEntity entity;
}
