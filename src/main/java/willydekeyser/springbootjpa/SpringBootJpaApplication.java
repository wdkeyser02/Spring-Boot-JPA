package willydekeyser.springbootjpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import willydekeyser.springbootjpa.model.Adres;
import willydekeyser.springbootjpa.model.User;
import willydekeyser.springbootjpa.repository.UserRepository;

@SpringBootApplication
public class SpringBootJpaApplication {

    UserRepository userRepository;

    public SpringBootJpaApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("CommandLineRunner running in the UnsplashApplication class...");

            User user = new User("Willy", new Adres("Koekelare 12345, Brussel"));
            userRepository.save(user);
            user = new User("Ken", new Adres("Koekelare 12345, Brussel"));
            userRepository.save(user);
            user = new User("Belen", new Adres("Koekelare 12345, Brussel"));
            userRepository.save(user);
        };
    }
}

