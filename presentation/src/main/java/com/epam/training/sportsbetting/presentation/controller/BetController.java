package com.epam.training.sportsbetting.presentation.controller;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeDto;
import com.epam.training.sportsbetting.presentation.facade.BetFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    @Autowired
    private BetFacade betFacade;

    @PostMapping("/{betId}/outcomes")
    public Bet createOutcomeForBet(@RequestBody @Valid CreateOutcomeDto createOutcomeDto, @PathVariable Long betId) {
        return betFacade.createOutcomeForBet(createOutcomeDto, betId);
    }
}
