package com.epam.training.sportsbetting.presentation.controller;

import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import com.epam.training.sportsbetting.presentation.dto.event.CreateEventDto;
import com.epam.training.sportsbetting.presentation.facade.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventFacade eventFacade;

    @PostMapping
    public SportEvent createEvent(@RequestBody @Valid CreateEventDto createEventDto) {
        return eventFacade.createEvent(createEventDto);
    }

    @PostMapping("/{eventId}/bets")
    public SportEvent createBetsForEvent(@RequestBody @Valid CreateBetDto createBetDto) {
        return eventFacade.createBetForEvent(createBetDto);
    }
}
