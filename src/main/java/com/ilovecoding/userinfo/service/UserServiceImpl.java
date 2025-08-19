package com.ilovecoding.userinfo.service;

import com.ilovecoding.userinfo.dto.UserDTO;
import com.ilovecoding.userinfo.entity.User;
import com.ilovecoding.userinfo.mapper.UserMapper;
import com.ilovecoding.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO saveUserInDb(UserDTO userDTO) {
        User servedUser=this.userRepo.save(UserMapper.INSTACE.mapUserDtoToUser(userDTO));
        return UserMapper.INSTACE.mapUserToUserDto(servedUser);
    }

    @Override
    public UserDTO fetchUerDetailsById(Integer userId) {
        Optional<User> fetchedUser=this.userRepo.findById(userId);
        if(fetchedUser.isPresent())
            return UserMapper.INSTACE.mapUserToUserDto(fetchedUser.get());
        return null;
    }
}
