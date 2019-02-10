package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.wager.Wager;

public interface WagerService {
    void deleteUnprocessed(Wager wagerToDelete);
}
