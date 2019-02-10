package com.epam.training.sportsbetting.core.domain.sportevent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TennisSportEvent")
@DiscriminatorValue("TennisSportEvent")
public class TennisSportEvent extends SportEvent{
}
