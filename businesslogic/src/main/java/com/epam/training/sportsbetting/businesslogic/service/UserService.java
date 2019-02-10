package com.epam.training.sportsbetting.businesslogic.service;

import com.epam.training.sportsbetting.core.domain.user.User;

public interface UserService {
    User getCurrentUser();

    User register(User user);

    User save(User user);
}
