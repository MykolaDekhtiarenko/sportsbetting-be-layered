package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeDto;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeOddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOutcomeDtoToOutcomeConverter implements Converter<CreateOutcomeDto, Outcome> {

    @Autowired
    private CreateOutcomeOddDtoToOutcomeOddConverter outcomeOddConverter;

    @Override
    public Outcome convert(CreateOutcomeDto createOutcomeDto) {
        Outcome outcome = new Outcome();
        outcome.setValue(createOutcomeDto.getDescription());
        outcome.setOutcomeOdds(convertOutcomeOdds(createOutcomeDto.getOdds(), outcome));
        return outcome;
    }

    private List<OutcomeOdd> convertOutcomeOdds(List<CreateOutcomeOddDto> outcomeOddDtos, Outcome outcome) {
        List<OutcomeOdd> outcomeOdds = outcomeOddConverter.convertAll(outcomeOddDtos);
        outcomeOdds.forEach(outcomeOdd -> outcomeOdd.setOutcome(outcome));
        return outcomeOdds;
    }
}
