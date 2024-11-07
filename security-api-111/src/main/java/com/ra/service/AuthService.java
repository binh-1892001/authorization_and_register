package com.ra.service;

import com.ra.exception.CustomException;
import com.ra.model.dto.*;

import java.util.List;

public interface AuthService {
    UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) throws CustomException;

    UserResponseDTO create(UserRequestDTO requestDTO);

    List<UserResponseDTO> findAll();

    void register(FormRegister formRegister);

    void handleChangePassword(ChangePassword changePassword) throws CustomException;
}
