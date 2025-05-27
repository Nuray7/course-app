package az.edu.itbrains.course.services;


import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();


boolean existsByEmail(String email);
void registerUser(RegisterDto registerDto);
}
