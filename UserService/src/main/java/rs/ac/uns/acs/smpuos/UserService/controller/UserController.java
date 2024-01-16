package rs.ac.uns.acs.smpuos.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.UserService.service.IUserService;
import rs.ac.uns.acs.smpuos.UserService.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value="/profile/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> findOne(@PathVariable String id){
        User user=this.userService.findById(id);
        if (user==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //User updates profile info
    @PutMapping(value = "/profile/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfile(@RequestBody User user) throws Exception {
        User updatedProfile = userService.update(user);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    //Admin blocking user profile
    @RequestMapping(value = "profile/block/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> blockUser(@PathVariable String id) {
        User user = userService.block(id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //Saving recipe to favorites
    @RequestMapping(value = "/{userId}/favorites", method = RequestMethod.POST)
    public List<String> addFavoriteRecipe(
            @PathVariable String userId, @RequestParam String recipeId) {
        return userService.addFavoriteRecipe(userId, recipeId);
    }
}
