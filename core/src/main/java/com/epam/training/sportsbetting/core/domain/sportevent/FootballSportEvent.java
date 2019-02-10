package com.epam.training.sportsbetting.core.domain.sportevent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "FootballSportEvent")
@DiscriminatorValue("FootballSportEvent")
public class FootballSportEvent extends SportEvent {
}
