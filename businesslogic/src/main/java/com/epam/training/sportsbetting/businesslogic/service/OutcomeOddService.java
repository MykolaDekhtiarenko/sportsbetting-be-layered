package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;

import java.util.List;

public interface OutcomeOddService {
    List<OutcomeOdd> findAll();
}
