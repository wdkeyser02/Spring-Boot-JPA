package willydekeyser.springbootjpa.service;

import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import willydekeyser.springbootjpa.model.Adres;
import willydekeyser.springbootjpa.model.Punten;
import willydekeyser.springbootjpa.model.User;
import willydekeyser.springbootjpa.repository.UserRepository;

import java.util.List;
import java.util.Random;

@Service
public class PuntenScheduler {

    private final UserRepository userRepository;

    public PuntenScheduler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 100_000)
    @Transactional
    public void schedulePunten() {
        IO.println("Scheduling Punten...");
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            int punt = new Random().nextInt(101);
            user.addPunten(new Punten(Integer.toString(punt)));
            userRepository.save(user);
        });
        printUsers();
    }

    @Scheduled(fixedRate = 36_000)
    @Transactional
    public void scheduleUsers() {
        IO.println("Scheduling Users...");
        int nummer = new Random().nextInt(11);
        if (userRepository.existsByName("User" + nummer)) {
            IO.println("User already exists: " + "User" + nummer);
        } else {
            User user = new User("User" + nummer, new Adres("Koekelare " + nummer + ", 1000 Brussel"), List.of());
            userRepository.save(user);
        }
        printUsers();
    }

    private void printUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(u -> {
            IO.println(u.getId() + " - " + u.getName() + " - " + u.getAdres().getStraat());
            u.getPunten().forEach(p -> IO.println(p.getId() + " - " + p.getPunten()));});
    }
}
