package rs.ac.uns.acs.smpuos.RecipeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;
import rs.ac.uns.acs.smpuos.RecipeService.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;


    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Recipe approveRecipe(String id) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setActive(true);
        recipeRepository.save(recipe);
        return recipe;

    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }


}
