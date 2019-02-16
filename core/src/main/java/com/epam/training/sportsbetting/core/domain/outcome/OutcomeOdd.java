package com.epam.training.sportsbetting.core.domain.outcome;

import com.epam.training.sportsbetting.core.domain.wager.Wager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "outcome_id", nullable = false)
    private Outcome outcome;

    @ToString.Exclude
    @OneToMany(mappedBy = "outcomeOdd", cascade = CascadeType.ALL)
    private List<Wager> wagers;


}
