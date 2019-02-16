package com.epam.training.sportsbetting.presentation.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateOutcomeDto {
    private String description;
    List<CreateOutcomeOddDto> odds;
}
