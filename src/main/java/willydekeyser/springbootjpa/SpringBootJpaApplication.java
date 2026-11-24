package willydekeyser.springbootjpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import willydekeyser.springbootjpa.model.Adres;
import willydekeyser.springbootjpa.model.Punten;
import willydekeyser.springbootjpa.model.User;
import willydekeyser.springbootjpa.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class SpringBootJpaApplication {

    UserRepository userRepository;

    public SpringBootJpaApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StandardServletMultipartResolver standardServletMultipartResolver) {
        return args -> {
            System.out.println("CommandLineRunner running in the UnsplashApplication class...");

            User user = new User("Willy", new Adres("Koekelare 1, 1000 Brussel"), List.of());
            userRepository.save(user);
            user = new User("Ken", new Adres("Koekelare 2, 1000 Brussel"), List.of());
            userRepository.save(user);
            user = new User("Belen", new Adres("Koekelare 3, 1000 Brussel"), List.of());
            userRepository.save(user);

            //user = userRepository.findByName("Willy");
            //user.addPunten(new Punten("29"));
            //user.addPunten(new Punten("59"));
            //user.addPunten(new Punten("19"));
            //user.addPunten(new Punten("99"));
            //userRepository.save(user);

            //user = userRepository.findByName("Ken");
            //user.addPunten(new Punten("27"));
            //user.addPunten(new Punten("56"));
            //user.addPunten(new Punten("14"));
            //user.addPunten(new Punten("92"));
            //userRepository.save(user);

            //user = userRepository.findByName("Belen");
            //user.addPunten(new Punten("67"));
            //user.addPunten(new Punten("16"));
            //userRepository.save(user);

            List<User> users = userRepository.findAll();

            users.forEach(u -> {
                IO.println(u.getId() + " - " + u.getName() + " - " + u.getAdres().getStraat());
                u.getPunten().forEach(p -> IO.println(p.getId() + " - " + p.getPunten()));});

        };
    }
}

