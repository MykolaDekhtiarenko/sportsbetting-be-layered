package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.businesslogic.service.EventService;
import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.presentation.converter.CreateEventDtoToEventConverter;
import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import com.epam.training.sportsbetting.presentation.dto.event.CreateEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventFacade implements EventFacade{

    @Autowired
    private CreateEventDtoToEventConverter eventDtoToEventConverter;

    @Autowired
    private EventService eventService;

    @Override
    public SportEvent createEvent(CreateEventDto createEventDto) {
        SportEvent eventToCreate = eventDtoToEventConverter.convert(createEventDto);
        return eventService.create(eventToCreate);
    }

    @Override
    public SportEvent createBetForEvent(CreateBetDto createBetDto) {

        return null;
    }
}
