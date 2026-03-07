package in.ub.main.services;


import java.util.List;

import org.springframework.data.domain.Page;

import in.ub.main.dto.UserDto;

public interface UserService {

    UserDto registerUser(UserDto dto);
    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto dto);
    List<UserDto> getAllUsers();
    
    Page<UserDto> getAllUsers(int page, int size);
}

