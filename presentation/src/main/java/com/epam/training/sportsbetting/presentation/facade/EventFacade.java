package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import com.epam.training.sportsbetting.presentation.dto.event.CreateEventDto;

public interface EventFacade {
    SportEvent createEvent(CreateEventDto createEventDto);

    SportEvent createBetForEvent(CreateBetDto createBetDto);
}
