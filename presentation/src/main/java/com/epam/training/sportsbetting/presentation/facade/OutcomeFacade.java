package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeOddDto;

public interface OutcomeFacade {
    Outcome createOddForOutcome(CreateOutcomeOddDto createOutcomeOddDto, Long outcomeId);

    Outcome markOutcomeAsWinning(Long outcomeId);
}
