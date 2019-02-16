package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeOddDto;
import org.springframework.stereotype.Component;

@Component
public class CreateOutcomeOddDtoToOutcomeOddConverter implements Converter<CreateOutcomeOddDto, OutcomeOdd> {

    @Override
    public OutcomeOdd convert(CreateOutcomeOddDto createOutcomeOddDto) {
        return OutcomeOdd.builder()
                .value(createOutcomeOddDto.getValue())
                .validFrom(createOutcomeOddDto.getValidFrom())
                .validTo(createOutcomeOddDto.getValidTo())
                .build();
    }
}
