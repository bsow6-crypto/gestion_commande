package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profil")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bio;

    private String telephone;
    private String photo;

    @OneToOne(mappedBy = "profil")
    private Utilisateur utilisateur;

    public Profil() {}

    public Profil(String bio, String telephone) {
        this.bio = bio;
        this.telephone = telephone;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getBio() { return bio; }
    public String getTelephone() { return telephone; }
    public String getPhoto() { return photo; }
    public Utilisateur getUtilisateur() { return utilisateur; }

    // SETTERS
    public void setBio(String bio) { this.bio = bio; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
}

