package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User max = new User("Max", "Max", "example@mail.com");
        User viktoria = new User("Vika", "Vika", "example1@mail.com");
        User kir = new User("Kir", "Kir", "example2@mail.com");
        User anna = new User("Anya", "Anya", "example3@mail.com");

        Car ford = new Car("Ford", 250);
        Car opel = new Car("Opel", 48);
        Car honda = new Car("Honda", 3);
        Car volvo = new Car("Volvo", 300);

        userService.add(max.setCar(ford).setUser(max));
        userService.add(viktoria.setCar(opel).setUser(viktoria));
        userService.add(kir.setCar(honda).setUser(kir));
        userService.add(anna.setCar(volvo).setUser(anna));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }

        System.out.println(userService.getUserByCar("Honda", 3));

        context.close();
    }
}
