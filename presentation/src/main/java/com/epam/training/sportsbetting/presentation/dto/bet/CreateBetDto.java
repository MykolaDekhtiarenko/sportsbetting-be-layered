package com.epam.training.sportsbetting.presentation.dto.bet;

import com.epam.training.sportsbetting.core.domain.bet.BetType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateBetDto {
    @NotBlank
    @Size(min = 5, max = 1000)
    private String description;
    @NotNull
    private BetType type;


}
