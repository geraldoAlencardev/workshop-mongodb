package gera.alencar.workshopmongodb.services;

import gera.alencar.workshopmongodb.domain.User;
import gera.alencar.workshopmongodb.dto.UserDTO;
import gera.alencar.workshopmongodb.repository.UserRepository;
import gera.alencar.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void updateData(User newUser, User oldUser) {
        newUser.setName(oldUser.getName());
        newUser.setEmail(oldUser.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }
}
