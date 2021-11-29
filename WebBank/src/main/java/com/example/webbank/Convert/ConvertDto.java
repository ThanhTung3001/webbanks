package com.example.webbank.Convert;

import com.example.webbank.Dto.AccountDto;
import com.example.webbank.Dto.CostumerDto;
import com.example.webbank.Dto.EmployeeDto;
import com.example.webbank.Dto.RoleDto;
import com.example.webbank.entity.AccountEntity;
import com.example.webbank.entity.CostumerEntity;
import com.example.webbank.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class ConvertDto {
    public AccountDto toAccount(AccountEntity account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountCode(account.getAccountCode());
        accountDto.setAvailable(account.getAvailable());
        accountDto.setId(account.getId());
        accountDto.setMin(account.getMin());
        RoleDto dto = new RoleDto();
        dto.setRole(account.getRoleAccount().getErole().toString());
        dto.setId(account.getRoleAccount().getId());
        accountDto.setRoles(dto);
        accountDto.setMin(account.getMin());
        return accountDto;
    }
    public  List<AccountDto>toListAccountDto(List<AccountEntity> accountEntities){
        List<AccountDto>accountDtos = new ArrayList<>();
         accountEntities.forEach(e->{
             accountDtos.add(toAccount(e));
         });
         return accountDtos;
    }
    public CostumerDto toCostumerDto (CostumerEntity costumerEntity){
          CostumerDto costumerDto = new CostumerDto();
          costumerDto.setAccountDtos(toAccount(costumerEntity.getEntity()));
          costumerDto.setAddress(costumerEntity.getAddress());
          costumerDto.setCreateDate(costumerEntity.getCreateDate());
          costumerDto.setCmnd(costumerEntity.getCmnd());
          costumerDto.setCreateBy(costumerEntity.getCreateBy());
          costumerDto.setDateOfBirth(costumerEntity.getDateOfBirth());
          costumerDto.setFullName(costumerEntity.getFullName());
          costumerDto.setId(costumerEntity.getId());
          costumerDto.setInterest(costumerEntity.getInterest());
          return costumerDto;
    }
    public List<CostumerDto>toListCostumerDto(List<CostumerEntity>costumerDtoList){
        List<CostumerDto>costumerDtos = new ArrayList<>();
        costumerDtoList.forEach(e->{
            costumerDtos.add(toCostumerDto(e));
        });
        return costumerDtos;
    }
    public EmployeeDto toEmployeeDto(EmployeeEntity employee ){
        EmployeeDto employeeDto =new EmployeeDto();
        employeeDto.setAddress(employee.getAddress());
      //  employeeDto.setAvailable(employee.getEntity().getAvailable());
    //    employeeDto.setBankCode(employee.getEntity().getAccountCode());
   //     employeeDto.setRole(employee.getEntity().getRoleAccount().getErole().toString());
        employeeDto.setId(employee.getId());
        employeeDto.setFullName(employee.getFullName());
        employeeDto.setExpr(employee.getExp());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setDataOfbirth(employee.getDateOfBirth());
        employeeDto.setCmnd(employee.getCmt());
        return employeeDto;
    }
    public List<EmployeeDto> toListEmployeeDto(List<EmployeeEntity>employeeEntities){
        List<EmployeeDto>employeeDtos =new ArrayList<>();
        employeeEntities.forEach(e->{
            employeeDtos.add(toEmployeeDto(e));
        });
        return  employeeDtos;
    }
}
