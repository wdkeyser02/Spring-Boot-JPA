package willydekeyser.springbootjpa.model;

import jakarta.persistence.*;

@Entity
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String straat;

    @OneToOne(mappedBy = "adres", cascade = CascadeType.ALL)
    private User user;

    public Adres() {
    }

    public Adres(String straat) {
        this.straat = straat;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }
}
