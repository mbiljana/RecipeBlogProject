package rs.ac.uns.acs.smpuos.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.UserService.model.User;
import rs.ac.uns.acs.smpuos.UserService.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(String id) {
        Optional<User> userOpt = this.userRepository.findById(id);
        if (!userOpt.isPresent()) {
            return null;
        } else {
            return userOpt.get();
        }
    }

    @Override
    public User update(User editedUser) {
        User user = this.findById(editedUser.getId());
        user.setFirstname(editedUser.getFirstname());
        user.setEmail(editedUser.getEmail());
        user.setLastname(editedUser.getLastname());
        user.setUsername(editedUser.getUsername());
        user.setBirth_date(editedUser.getBirth_date());
        if (user == null) {
            throw new IllegalStateException("User does not exist!");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User block(String id) {
        User user = userRepository.findById(id).get();
        user.setBlocked(true);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<String> addFavoriteRecipe(String userId, String recipeId) {
        // Retrieve the user from the repository
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Get the existing favorites list
            List<String> favorites = user.getFavorites();
            // Check if the recipeId is not already in the favorites list
            if (!favorites.contains(recipeId)) {
                // Add the recipeId to the favorites list
                favorites.add(recipeId);

                // Save the updated user back to the repository
                userRepository.save(user);
            }
            // Return the updated list of favorites
            return favorites;
        } else {
            // Handle the case where the user is not found
            return null;
        }
    }
}

