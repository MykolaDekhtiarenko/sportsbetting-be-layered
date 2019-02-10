package com.epam.training.sportsbetting.businesslogic.service.environment;

import java.util.Optional;

public interface PropertyService {
    Optional<String> getProperty(String name);

    String getPropertyOrDefault(String name, String defaultValue);
}
