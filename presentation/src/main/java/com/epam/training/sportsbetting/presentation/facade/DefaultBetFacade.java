package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.businesslogic.service.BetService;
import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.presentation.converter.CreateOutcomeDtoToOutcomeConverter;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBetFacade implements BetFacade {

    @Autowired
    private CreateOutcomeDtoToOutcomeConverter outcomeConverter;

    @Autowired
    private BetService betService;

    @Override
    public Bet createOutcomeForBet(CreateOutcomeDto createOutcomeDto, Long betId) {
        Bet bet = betService.findById(betId).orElseThrow(() -> new RuntimeException(""));
        Outcome outcome = outcomeConverter.convert(createOutcomeDto);
        betService.create(outcome, bet);
        return bet;
    }
}
