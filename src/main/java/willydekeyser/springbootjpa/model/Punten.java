package willydekeyser.springbootjpa.model;

import jakarta.persistence.*;

@Entity
public class Punten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String punten;
    @ManyToOne
    private User user;

    public Punten() {
    }

    public Punten(String punten) {
        this.punten = punten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPunten() {
        return punten;
    }

    public void setPunten(String punten) {
        this.punten = punten;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
