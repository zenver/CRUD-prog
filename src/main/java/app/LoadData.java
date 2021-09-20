package app;

import app.model.User;
import app.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@Transactional
public class LoadData {

    final
    UserService userService;

    public LoadData(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    @Transactional
    public void loadData() {

        User user1 = new User("Andrey", "Labazin", "andrey.labazin@gmail.com", "qwerty");
        User user2 = new User("Anna", "Borovkova", "anna.borovkova@gmail.com", "1q2w3e");
        User user3 = new User("Boris", "Zakirov", "boris.zakirov@gmail.com", "05031987");
        User user4 = new User("Oleg", "Makarov", "oleg.makarov@gmail.com", "ghbdtn123");
        User user5 = new User("Igor", "Medvedev", "igor.medvedev@gmail.com", "drowssap");

        userService.createOrUpdateUser(user1);
        userService.createOrUpdateUser(user2);
        userService.createOrUpdateUser(user3);
        userService.createOrUpdateUser(user4);
        userService.createOrUpdateUser(user5);
    }
}
