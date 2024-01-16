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
        User u1 = new User("pavle","pavle", Role.REGUSER,"Pavle","Bugarski", "pavle@gmail.com","557589","/assets/pavle.jpg");
        User u2 = new User("mile","pavle", Role.REGUSER,"Milorad","Stankovic", "mile@gmail.com","557589","/assets/mile.jpg");
        User u3 = new User("zivko","pavle", Role.REGUSER,"Zivko","Lovic", "zivko@gmail.com","557589","/assets/zivko.jpg");
        User u4 = new User("zaklina","pavle", Role.REGUSER,"Zaklina","Jovanovic", "zaklina@gmail.com","557589","/assets/zaklina.jpg");

        this.userRepository.save(u1);
        this.userRepository.save(u2);
        this.userRepository.save(u3);
        this.userRepository.save(u4);

    }
}
