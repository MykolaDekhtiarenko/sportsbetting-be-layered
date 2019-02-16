package com.epam.training.sportsbetting.core.domain.sportevent;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Version
    private Integer version;

    @ToString.Exclude
    @OneToMany(mappedBy = "sportEvent", cascade = CascadeType.ALL)
    private List<Bet> bets = new ArrayList<>();

}
