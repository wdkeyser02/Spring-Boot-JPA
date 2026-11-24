package willydekeyser.springbootjpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Adres adres;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Punten> punten = new ArrayList<>();

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Adres adres, List<Punten> punten) {
        this.adres = adres;
        this.name = name;
        if (punten != null) {
        punten.forEach(this::addPunten);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<Punten> getPunten() {
        return punten;
    }

    public void setPunten(List<Punten> punten) {
        this.punten = punten;
    }

    public void addPunten(Punten punten) {
        this.punten.add(punten);
        punten.setUser(this);
        
    }
}
