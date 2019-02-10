package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.core.repository.OutcomeOddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOutcomeOddService implements OutcomeOddService {

    @Autowired
    private OutcomeOddRepository outcomeOddRepository;

    @Override
    public List<OutcomeOdd> findAll() {
        return outcomeOddRepository.findAll();
    }
}
