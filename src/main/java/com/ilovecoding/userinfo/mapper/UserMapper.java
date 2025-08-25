package com.ilovecoding.userinfo.mapper;

import com.ilovecoding.userinfo.dto.UserDTO;
import com.ilovecoding.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDtoToUser(UserDTO userDTO);
    UserDTO mapUserToUserDto(User user);

}
