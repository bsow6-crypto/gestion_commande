package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true, length = 191)
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profil_id")
    private Profil profil;

    public Utilisateur() {}

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public Profil getProfil() { return profil; }

    // SETTERS
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
}

