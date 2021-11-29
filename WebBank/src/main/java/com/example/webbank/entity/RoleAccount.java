package com.example.webbank.entity;

import com.example.webbank.EnumDefauld.EROLE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "typeAccount")
public class RoleAccount extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EROLE erole;
    @JsonIgnore
    @OneToMany(mappedBy = "roleAccount")
    private List<AccountEntity>accountEntities;
}
