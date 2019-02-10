package com.epam.training.sportsbetting.core.repository;

import com.epam.training.sportsbetting.core.domain.outcome.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {
}
