package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.core.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultEventService implements EventService {
    @Autowired
    private SportEventRepository eventRepository;

    @Override
    @Transactional
    public SportEvent create(SportEvent eventToCreate) {
        return eventRepository.save(eventToCreate);
    }
}
