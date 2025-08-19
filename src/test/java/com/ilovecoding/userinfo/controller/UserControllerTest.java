package com.ilovecoding.userinfo.controller;

import com.ilovecoding.userinfo.dto.UserDTO;
import com.ilovecoding.userinfo.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserServiceImpl userService;

    @BeforeEach
    public  void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser(){
        //Create the user mock object
        UserDTO mockUserDto= new UserDTO(1,"Kumar Balambeed","kumar_123","Karnataka","Bengaluru");

        //mock the service behavior servedUser
        when(userService.saveUserInDb(mockUserDto)).thenReturn(mockUserDto);

        //call the controller method
        ResponseEntity<UserDTO> response = userController.addUser(mockUserDto);

        //verify the result using assertEquals
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(mockUserDto,response.getBody());

        //verify the service method was called
        verify(userService,times(1)).saveUserInDb(mockUserDto);
    }

    @Test
    public void testFindUserById(){
        //Create Mock userId
        Integer mockUserId=1;

        //Create Mock User Object
        UserDTO mockUserDto= new UserDTO(1,"Kumar Balambeed","kumar_123","Karnataka","Bengaluru");

        //mock the service behavior
        when(userService.fetchUerDetailsById(mockUserId)).thenReturn(mockUserDto);
        
        //call the controller method
        ResponseEntity<UserDTO> response = userController.findUserById(mockUserId);

        //verify the result
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(mockUserDto,response.getBody());

        //verify the service method was called
        verify(userService,times(1)).fetchUerDetailsById(mockUserId);
    }


}
