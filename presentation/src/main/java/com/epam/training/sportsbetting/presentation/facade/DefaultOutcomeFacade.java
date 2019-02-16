package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.businesslogic.service.OutcomeService;
import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.core.exeptions.EntityWithSuchIdDoesNotExistException;
import com.epam.training.sportsbetting.presentation.converter.CreateOutcomeOddDtoToOutcomeOddConverter;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeOddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultOutcomeFacade implements OutcomeFacade {

    private static final String OUTCOME_DOES_NOT_EXIST = "Outcome with id: %s does not exist!";

    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private CreateOutcomeOddDtoToOutcomeOddConverter outcomeOddConverter;

    @Override
    public Outcome createOddForOutcome(CreateOutcomeOddDto createOutcomeOddDto, Long outcomeId) {
        Outcome outcome = outcomeService.findById(outcomeId)
                .orElseThrow(() -> new EntityWithSuchIdDoesNotExistException(String.format(OUTCOME_DOES_NOT_EXIST, outcomeId)));
        OutcomeOdd outcomeOdd = outcomeOddConverter.convert(createOutcomeOddDto);
        return outcomeService.createOutcomeOddForOutcome(outcomeOdd, outcome);
    }

    @Override
    public Outcome markOutcomeAsWinning(Long outcomeId) {
        Outcome outcome = outcomeService.findById(outcomeId)
                .orElseThrow(() -> new EntityWithSuchIdDoesNotExistException(String.format(OUTCOME_DOES_NOT_EXIST, outcomeId)));
        return outcomeService.markAsWinning(outcome);
    }
}
