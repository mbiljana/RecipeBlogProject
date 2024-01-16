package rs.ac.uns.acs.smpuos.AuthService.service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.AuthService.model.User;
import rs.ac.uns.acs.smpuos.AuthService.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User userRequest) {
        User existingUser = this.userRepository.findByUsername(userRequest.getUsername());
        if (existingUser != null) {
            // If user exists, update the values
            existingUser.setName(userRequest.getName());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setRole(userRequest.getRole());
            existingUser.setPassword(userRequest.getPassword());
            existingUser.setSurname(userRequest.getSurname());
            existingUser.setPhone(userRequest.getPhone());
            return this.userRepository.save(existingUser);
        } else {
            // If user doesn't exist, create a new one
            User newUser = new User();
            newUser.setName(userRequest.getName());
            newUser.setEmail(userRequest.getEmail());
            newUser.setRole(userRequest.getRole());
            newUser.setPassword(userRequest.getPassword());
            newUser.setSurname(userRequest.getSurname());
            newUser.setUsername(userRequest.getUsername());
            newUser.setPhone(userRequest.getPhone());
            return this.userRepository.save(newUser);
        }
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
