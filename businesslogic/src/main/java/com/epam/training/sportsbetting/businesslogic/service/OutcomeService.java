package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;

import java.util.List;
import java.util.Optional;

public interface OutcomeService {

    List<Outcome> findAll();

    Optional<Outcome> findById(Long id);

    Outcome chooseWinOutcome(Long betId);

    Outcome markAsWinning(Outcome outcome);

    Outcome createOutcomeOddForOutcome(OutcomeOdd outcomeOdd, Outcome outcome);
}
