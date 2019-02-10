package com.epam.training.sportsbetting.core.domain.outcome;

import com.epam.training.sportsbetting.core.domain.wager.Wager;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class OutcomeOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    @ManyToOne
    @JoinColumn(name = "outcome_id", nullable = false)
    private Outcome outcome;

    @ToString.Exclude
    @OneToMany(mappedBy = "outcomeOdd", cascade = CascadeType.ALL)
    private List<Wager> wagers;


}
