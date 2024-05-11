package com.global.BackEnd.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddAccountDto {
    private Long accountNumber;
    private Double balance;
    private Long nationalId;
}
