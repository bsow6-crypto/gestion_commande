package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private double prix;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Produit() {}

    public Produit(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public int getStock() { return stock; }
    public Categorie getCategorie() { return categorie; }

    // SETTERS
    public void setNom(String nom) { this.nom = nom; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setStock(int stock) { this.stock = stock; }
}

