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
        User user = new User();

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        user.setPassword(userRequest.getPassword());
        user.setSurname(userRequest.getSurname());
        user.setUsername(userRequest.getUsername());
        user.setPhone(userRequest.getPhone());
        return this.userRepository.save(user);
    }
}
