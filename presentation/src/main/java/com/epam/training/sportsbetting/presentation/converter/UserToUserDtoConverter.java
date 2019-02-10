package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.user.User;
import com.epam.training.sportsbetting.presentation.dto.user.read.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .accountNumber(user.getAccountNumber())
                .dateOfBirth(user.getDateOfBirth())
                .balance(user.getBalance())
                .currency(user.getCurrency())
                .build();
    }
}
