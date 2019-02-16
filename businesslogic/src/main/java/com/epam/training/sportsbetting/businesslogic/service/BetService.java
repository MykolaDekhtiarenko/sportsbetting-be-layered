package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.core.domain.outcome.Outcome;

import java.util.Optional;

public interface BetService {
    Optional<Bet> findById(Long id);

    Bet create(Outcome outcome, Bet bet);
}
