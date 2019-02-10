package com.epam.training.sportsbetting.core.domain.wager;

import com.epam.training.sportsbetting.core.domain.Currency;
import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import com.epam.training.sportsbetting.core.domain.user.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Wager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "processed", columnDefinition = "SMALLINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean processed;

    @Column(name = "win", columnDefinition = "SMALLINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean win;

    @ManyToOne
    @JoinColumn(name = "outcome_odd_id", nullable = false)
    private OutcomeOdd outcomeOdd;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private User user;

    public boolean eventIsStarted(){
        SportEvent event = getOutcomeOdd().getOutcome().getBet().getSportEvent();
        return event.getStartDate().isAfter(LocalDateTime.now());
    }
}
