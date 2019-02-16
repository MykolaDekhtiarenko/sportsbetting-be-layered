package com.epam.training.sportsbetting.core.repository;

import com.epam.training.sportsbetting.core.domain.bet.Bet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BetRepository extends JpaRepository<Bet, Long> {
}
