package com.epam.training.sportsbetting.core.repository;

import com.epam.training.sportsbetting.core.domain.sportevent.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
}
