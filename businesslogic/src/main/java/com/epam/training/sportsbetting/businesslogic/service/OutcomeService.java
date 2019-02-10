package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;

import java.util.List;
import java.util.Optional;

public interface OutcomeService {
    Outcome save(Outcome outcome);

    List<Outcome> findAll();

    Optional<Outcome> get(Long id);

    Outcome chooseWinOutcome(Long betId);
}
