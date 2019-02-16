package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.core.domain.sportevent.FootballSportEvent;
import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.core.domain.sportevent.TennisSportEvent;
import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import com.epam.training.sportsbetting.presentation.dto.event.CreateEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateEventDtoToEventConverter implements Converter<CreateEventDto, SportEvent> {

    @Autowired
    private CreateBetDtoToBetConverter createBetDtoToBetConverter;

    @Override
    public SportEvent convert(CreateEventDto createEventDto) {
        SportEvent event = createSportEventByType(createEventDto.getType());
        event.setTitle(createEventDto.getTitle());
        event.setStartDate(createEventDto.getStartDate());
        event.setEndDate(createEventDto.getEndDate());
        event.setBets(convertBets(createEventDto.getBets(), event));
        return event;
    }

    private List<Bet> convertBets(List<CreateBetDto> betsToCreate, SportEvent event) {
        List<Bet> bets = createBetDtoToBetConverter.convertAll(betsToCreate);
        bets.forEach(bet -> bet.setSportEvent(event));
        return bets;
    }

    private SportEvent createSportEventByType(CreateEventDto.EventType type) {
        return type == CreateEventDto.EventType.FOOTBALL ? new FootballSportEvent() : new TennisSportEvent();
    }
}
