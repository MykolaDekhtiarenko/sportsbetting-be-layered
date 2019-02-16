package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import org.springframework.stereotype.Component;

@Component
public class CreateBetDtoToBetConverter implements Converter<CreateBetDto, Bet> {
    @Override
    public Bet convert(CreateBetDto createBetDto) {
        return Bet.builder()
                .type(createBetDto.getType())
                .description(createBetDto.getDescription())
                .build();
    }
}
