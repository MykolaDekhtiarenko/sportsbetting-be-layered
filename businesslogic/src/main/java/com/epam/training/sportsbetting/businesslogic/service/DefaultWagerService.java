package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.wager.Wager;
import com.epam.training.sportsbetting.core.repository.WagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.training.sportsbetting.core.exeptions.SportBettingGeneralException;

@Service
public class DefaultWagerService implements WagerService {

    private static final String STARTED_EVENT_DELETION = "You are not able to remove wager which event is started";

    @Autowired
    private WagerRepository wagerRepository;

    @Override
    public void deleteUnprocessed(Wager wagerToDelete) {
        if (wagerToDelete.eventIsStarted()) {
            throw new SportBettingGeneralException(STARTED_EVENT_DELETION);
        }
        wagerRepository.deleteById(wagerToDelete.getId());
    }

}
