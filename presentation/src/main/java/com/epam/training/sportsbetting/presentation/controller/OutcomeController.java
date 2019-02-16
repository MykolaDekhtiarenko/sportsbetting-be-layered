package com.epam.training.sportsbetting.presentation.controller;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import com.epam.training.sportsbetting.presentation.dto.CreateOutcomeOddDto;
import com.epam.training.sportsbetting.presentation.facade.OutcomeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/outcomes")
public class OutcomeController {

    @Autowired
    private OutcomeFacade outcomeFacade;

    @PostMapping("/{outcomeId}/odd")
    public Outcome createOddForOutcome(@PathVariable Long outcomeId,
                                       @RequestBody @Valid CreateOutcomeOddDto createOutcomeOddDto) {
        return outcomeFacade.createOddForOutcome(createOutcomeOddDto, outcomeId);
    }

    @PatchMapping("/{outcomeId}/winning")
    public Outcome markOutcomeAsWinning(@PathVariable Long outcomeId) {
        return outcomeFacade.markOutcomeAsWinning(outcomeId);
    }

}
