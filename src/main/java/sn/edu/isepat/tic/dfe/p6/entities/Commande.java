package sn.edu.isepat.tic.dfe.p6.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCommande;
    private String statut;
    private double montantTotal;

    @ManyToMany
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits = new ArrayList<>();

    public Commande() {}

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        montantTotal += produit.getPrix();
    }

    public void retirerProduit(Produit produit) {
        produits.remove(produit);
        montantTotal -= produit.getPrix();
    }

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public LocalDate getDateCommande() { return dateCommande; }
    public String getStatut() { return statut; }
    public double getMontantTotal() { return montantTotal; }
    public List<Produit> getProduits() { return produits; }

    public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
}

