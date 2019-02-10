package com.epam.training.sportsbetting.presentation.dto.user.read;

import com.epam.training.sportsbetting.core.domain.Currency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    private String email;
    private String name;
    private String accountNumber;
    private Integer balance;
    private Currency currency;
    private LocalDate dateOfBirth;
}
