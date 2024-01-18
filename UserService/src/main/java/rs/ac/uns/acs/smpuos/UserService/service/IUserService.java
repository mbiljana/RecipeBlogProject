package rs.ac.uns.acs.smpuos.UserService.service;
import rs.ac.uns.acs.smpuos.UserService.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    User update(User editedUser);

    User findById(String id);

    User block(String id);

    List<String> addFavoriteRecipe(String userId, String recipeId);

    void save(User user);

    User findByUsername(String username);

    User findByAuthId(String authId);
    List<String> getFavoriteRecipes(String userId);
}
