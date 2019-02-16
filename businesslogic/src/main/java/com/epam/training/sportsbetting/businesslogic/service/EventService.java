package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;

public interface EventService {
    SportEvent create(SportEvent eventToCreate);
}
