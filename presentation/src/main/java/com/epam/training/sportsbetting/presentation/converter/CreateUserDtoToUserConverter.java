package com.epam.training.sportsbetting.presentation.converter;

import com.epam.training.sportsbetting.core.domain.user.User;
import com.epam.training.sportsbetting.presentation.dto.user.create.CreateUserDto;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserConverter implements Converter<CreateUserDto, User> {

    @Override
    public User convert(CreateUserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .accountNumber(userDto.getAccountNumber())
                .dateOfBirth(userDto.getDateOfBirth())
                .build();
    }
}
