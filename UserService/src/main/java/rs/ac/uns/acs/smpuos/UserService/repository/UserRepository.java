package rs.ac.uns.acs.smpuos.UserService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.UserService.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername (String username);
    User findByAuthId (String authId);
}
