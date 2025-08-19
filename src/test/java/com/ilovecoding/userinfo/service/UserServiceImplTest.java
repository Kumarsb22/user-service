package com.ilovecoding.userinfo.service;

import com.ilovecoding.userinfo.dto.UserDTO;
import com.ilovecoding.userinfo.entity.User;
import com.ilovecoding.userinfo.mapper.UserMapper;
import com.ilovecoding.userinfo.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepo userRepo;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUserInDb(){
        //create the mock user object
        User mockUser= new User(1,"Kumar Balambeed","kumar@123","Karnataka","Bengaluru");

        //mock the repository behavior
        when(userRepo.save(mockUser)).thenReturn(mockUser);

        //call the service method
        UserDTO mockUserDTO = UserMapper.INSTACE.mapUserToUserDto(mockUser);
        UserDTO userDTO = userService.saveUserInDb(mockUserDTO);
        User response = UserMapper.INSTACE.mapUserDtoToUser(userDTO);

        //verify the result
        assertEquals(mockUser,response);

        //verify the repository method was called
        verify(userRepo,times(1)).save(mockUser);
    }

    @Test
    public void testFetchUserDetailsById(){
        //mock the userId
        Integer mockUserId=1;

        //mock the user object
        User mockUser= new User(1,"Kumar Balambeed","kumar@123","Karnataka","Bengaluru");

        //mock the repository behavior
        when(userRepo.findById(mockUserId)).thenReturn(Optional.ofNullable(mockUser));

        //call the service method
        UserDTO userDTO = userService.fetchUerDetailsById(mockUserId);
        User response = UserMapper.INSTACE.mapUserDtoToUser(userDTO);

        //verify the result
        assertEquals(mockUser,response);

        //verify the repository method was called
        verify(userRepo,times(1)).findById(mockUserId);
    }
}
