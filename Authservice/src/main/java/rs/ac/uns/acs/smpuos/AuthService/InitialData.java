package rs.ac.uns.acs.smpuos.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.uns.acs.smpuos.AuthService.model.Role;
import rs.ac.uns.acs.smpuos.AuthService.model.User;
import rs.ac.uns.acs.smpuos.AuthService.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialData {

    private final UserRepository userRepository;

    @Autowired
    public InitialData(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @PostConstruct
    public void init(){
        User u = new User("admin","admin", Role.ADMIN,"Pavle","Bugarski", "pavle@gmail.com","557589");
        this.userRepository.save(u);
    }
}
