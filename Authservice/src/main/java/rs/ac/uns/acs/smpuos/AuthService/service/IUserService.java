package rs.ac.uns.acs.smpuos.AuthService.service;

import rs.ac.uns.acs.smpuos.AuthService.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(String id);
    User findByUsername(String username);
    List<User> findAll ();
    User save(User userRequest);

}
