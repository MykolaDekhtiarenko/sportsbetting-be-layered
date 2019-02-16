package com.epam.training.sportsbetting.presentation.dto.event;

import com.epam.training.sportsbetting.presentation.dto.bet.CreateBetDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CreateEventDto {

    @NotBlank
    @Size(min = 5, max = 100)
    private String title;
    @NotNull
    private EventType type;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;

    private List<CreateBetDto> bets;

    public enum EventType {
        FOOTBALL, TENNIS
    }
}
