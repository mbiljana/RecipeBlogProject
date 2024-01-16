package rs.ac.uns.acs.smpuos.AuthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.util.UriComponentsBuilder;
import rs.ac.uns.acs.smpuos.AuthService.model.Role;
import rs.ac.uns.acs.smpuos.AuthService.model.User;
import rs.ac.uns.acs.smpuos.AuthService.service.IUserService;
import rs.ac.uns.acs.smpuos.AuthService.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class AuthController {

    @Autowired
    private IUserService userService;


    User newUser = new User();

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User userRequest) throws Exception {

        User existUser = this.userService.findByUsername(userRequest.getUsername());
        if (existUser != null) {
            throw new Exception("User already exists");
        }

        User user = this.userService.save(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginRequest, HttpSession session) throws Exception {
        User user = this.userService.findByUsername(loginRequest.getUsername());


        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new Exception("Invalid username or password");
        }
        session.setAttribute("user", user);
        newUser = (User) session.getAttribute("user");
        System.out.println("Ovo je imeeee" + newUser.getUsername());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/logged-user")
    public ResponseEntity<User> getLoggedUser(HttpSession session) {
        System.out.println("Ovo je ime s druge strane mozda radi" + newUser.getUsername());
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/user-role")
    public ResponseEntity<Role> getUserRole(HttpSession session) {
        System.out.println("Ovo je uloga " + newUser.getRole());
        Role role = newUser.getRole();
        return ResponseEntity.ok(role);
    }

    @GetMapping("/signout")
    public ResponseEntity<User> signout(HttpSession session) {
        User user = this.userService.findByUsername("Anon");
        newUser = user;
        System.out.println("Ovo je uloga " + newUser.getRole());
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        User user = userService.findById(userId).get();
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        userService.delete(user);
        return new ResponseEntity<>("Recipe deleted successfully", HttpStatus.OK);
    }


    @GetMapping(path = "/get-users" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        List<User> regusers = new ArrayList<>();
        for (User u: users) {
            if(u.getRole().equals(Role.REGUSER)){
                regusers.add(u);
            }
        }
        return new ResponseEntity<List<User>>(regusers,HttpStatus.OK);
    }






}
