package com.stackroute.bootstrap;

import com.stackroute.domain.Role;
import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppDataBootstrap implements CommandLineRunner {
    private UserRepository userRepository;

    /**
     * To get the property values
     */
    @Value("${app.seeddata.id1}")
    private String id1;

    @Value("${app.seeddata.id2}")
    private String id2;

    @Value("${app.seeddata.password1}")
    private String password1;

    @Value("${app.seeddata.password2}")
    private String password2;

    @Value("${app.seeddata.role1}")
    private Role role1;

    @Value("${app.seeddata.role2}")
    private Role role2;
    @Value("${app.seeddata.logMessage}")
    private String logMessage;


    /**
     * Use constructor based DI to inject UserRepository here
     */
    @Autowired
    public AppDataBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(id1, password1,role1);
        User user2 = new User(id2, password2,role2);
        userRepository.save(user1);
        userRepository.save(user2);
        log.debug(logMessage);
    }
}
