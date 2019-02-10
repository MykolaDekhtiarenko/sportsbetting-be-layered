package com.epam.training.sportsbetting.core.repository;

import com.epam.training.sportsbetting.core.domain.outcome.OutcomeOdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeOddRepository extends JpaRepository<OutcomeOdd, Long> {
}
