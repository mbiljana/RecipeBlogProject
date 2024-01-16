package rs.ac.uns.acs.smpuos.UserService;
import rs.ac.uns.acs.smpuos.UserService.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.uns.acs.smpuos.UserService.repository.UserRepository;
import rs.ac.uns.acs.smpuos.UserService.model.User;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialData {

    private final UserRepository userRepository;

    @Autowired
    public InitialData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        List<String> favorites = new ArrayList<>();
        favorites.add("1");

        User u1 = new User("1", "Ana123", "Ana", "Perić" , Role.REGUSER,"anaperic@gmail.com", "30-11-1998", false, favorites);
        userRepository.save(u1);
    }
}
