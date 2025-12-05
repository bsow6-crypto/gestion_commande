package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produit> produits = new ArrayList<>();

    public Categorie() {}

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Ajouter un produit à la catégorie et mettre à jour le produit
    public void ajouterProduit(Produit p) {
        p.setCategorie(this);  // MAJ côté Produit
        produits.add(p);       // MAJ côté Categorie
    }

    public void retirerProduit(Produit p) {
        p.setCategorie(null);
        produits.remove(p);
    }

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
}

