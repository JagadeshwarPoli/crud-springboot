package com.self.crud.service;

import com.self.crud.entity.User;
import com.self.crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User oldUpdate = repository.findById(id).orElse(null);

        if (oldUpdate != null) {
            oldUpdate.setName(user.getName());
            oldUpdate.setAge(user.getAge());
            return repository.save(oldUpdate);
        }
        return null;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}