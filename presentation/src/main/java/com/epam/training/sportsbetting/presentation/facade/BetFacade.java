package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeDto;

public interface BetFacade {
    Bet createOutcomeForBet(CreateOutcomeDto createOutcomeDto, Long betId);
}
