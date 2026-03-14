package in.ub.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import in.ub.main.dto.UserDto;
import in.ub.main.entities.User;
import in.ub.main.exceptionhandler.ResourceNotFoundException;
import in.ub.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto registerUser(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User savedUser = userRepository.save(user);

        UserDto response = new UserDto();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }
    
    public UserDto updateUser(Long id, UserDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);

        return new UserDto(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                null,
                saved.getRole()
        );
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userRepository.delete(user);
    }
    
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(user ->
                new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        null,
                        user.getRole()
                )
        ).toList();
    }

  

    @Override
    public Page<UserDto> getAllUsers(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<User> users = userRepository.findAll(pageable);

        return users.map(user ->
                new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        null,
                        user.getRole()
                )
        );
    }
    
    
}