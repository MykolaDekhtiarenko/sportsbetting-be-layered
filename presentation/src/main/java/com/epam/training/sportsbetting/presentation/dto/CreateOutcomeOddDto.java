package com.epam.training.sportsbetting.presentation.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class CreateOutcomeOddDto {

    @NotNull
    @DecimalMin(value = "0")
    private Double value;

    private LocalDate validFrom;

    private LocalDate validTo;
}
