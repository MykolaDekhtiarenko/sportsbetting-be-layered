package com.epam.training.sportsbetting.presentation.facade;

import com.epam.training.sportsbetting.presentation.dto.user.create.CreateUserDto;
import com.epam.training.sportsbetting.presentation.dto.user.read.UserDto;
import com.epam.training.sportsbetting.presentation.dto.user.update.UpdateUserDto;
import com.epam.training.sportsbetting.presentation.dto.wager.WagerDto;

import java.util.List;

public interface UserFacade {
    UserDto getProfile();

    UserDto registerUser(CreateUserDto userDto);

    List<WagerDto> getCurrentUserWagers();

    void deleteUnprocessedWager(Long wagerId);

    UserDto updateUserDto(UpdateUserDto updateUserDto);
}
