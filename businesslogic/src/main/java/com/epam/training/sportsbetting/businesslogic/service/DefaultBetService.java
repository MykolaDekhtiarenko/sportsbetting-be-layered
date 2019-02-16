package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.core.repository.BetRepository;
import com.epam.training.sportsbetting.core.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultBetService implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private OutcomeRepository outcomeRepository;

    @Override
    public Optional<Bet> findById(Long id) {
        return betRepository.findById(id);
    }

    @Override
    public Bet create(Outcome outcome, Bet bet) {
        outcome.setBet(bet);
        outcomeRepository.save(outcome);
        return bet;
    }
}
