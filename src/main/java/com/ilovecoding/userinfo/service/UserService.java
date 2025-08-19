package com.ilovecoding.userinfo.service;

import com.ilovecoding.userinfo.dto.UserDTO;

public interface UserService {
    UserDTO saveUserInDb(UserDTO userDTO);

    UserDTO fetchUerDetailsById(Integer userId);
}
