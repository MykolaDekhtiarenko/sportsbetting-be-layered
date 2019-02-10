package com.epam.training.sportsbetting.core.repository;

import com.epam.training.sportsbetting.core.domain.wager.Wager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WagerRepository extends JpaRepository<Wager, Long> {
}
