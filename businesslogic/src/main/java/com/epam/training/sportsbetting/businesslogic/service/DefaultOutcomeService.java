package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.core.domain.user.User;
import com.epam.training.sportsbetting.core.domain.wager.Wager;
import com.epam.training.sportsbetting.core.repository.BetRepository;
import com.epam.training.sportsbetting.core.repository.OutcomeOddRepository;
import com.epam.training.sportsbetting.core.repository.OutcomeRepository;
import com.epam.training.sportsbetting.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DefaultOutcomeService implements OutcomeService {
    private static final String BET_DOES_NOT_EXISTS = "Bet with id: %s doesn't exist!";

    @Autowired
    private OutcomeRepository outcomeRepository;

    @Autowired
    private OutcomeOddRepository outcomeOddRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BetRepository betRepository;

    @Override
    @Transactional
    public Outcome chooseWinOutcome(Long id) {
        List<Outcome> outcomes = betRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(BET_DOES_NOT_EXISTS, id)))
                .getOutcomes();
        return outcomes.get(new Random().nextInt(outcomes.size()));
    }

    @Override
    public Outcome markAsWinning(Outcome winningOutcome) {
        markOutcomes(winningOutcome);
        calculateBalanceForWinners(winningOutcome);
        return winningOutcome;
    }

    @Override
    public Outcome createOutcomeOddForOutcome(OutcomeOdd outcomeOdd, Outcome outcome) {
        outcomeOdd.setOutcome(outcome);
        outcomeOddRepository.save(outcomeOdd);
        return outcome;
    }

    @Override
    public List<Outcome> findAll() {
        return outcomeRepository.findAll();
    }

    @Override
    public Optional<Outcome> findById(Long id) {
        return outcomeRepository.findById(id);
    }

    private void markOutcomes(Outcome winOutcome) {
        List<Outcome> allOutcomes = winOutcome.getBet().getOutcomes();
        allOutcomes.forEach(outcome -> outcome.setWin(false));
        winOutcome.setWin(true);
        outcomeRepository.saveAll(allOutcomes);
    }

    private void calculateBalanceForWinners(Outcome winOutcome) {
        List<Wager> winningWagers = winOutcome.getOutcomeOdds().stream()
                .flatMap(odd -> odd.getWagers().stream()).collect(Collectors.toList());
        winningWagers.forEach(wager -> {
            User user = wager.getUser();
            double won = wager.getAmount() * wager.getOutcomeOdd().getValue();
            user.setBalance((int) (user.getBalance() + won));
            userRepository.save(user);
        });

    }

}
