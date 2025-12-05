package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import sn.edu.isepat.tic.dfe.p6.entities.*;
import sn.edu.isepat.tic.dfe.p6.config.JPAUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Création Utilisateur + Profil

            Profil profil1 = new Profil("Développeur Front-end", "77 123 45 67");
            Utilisateur user1 = new Utilisateur("Samba Gaye", "mgage@isepat.edu.sn");
            user1.setProfil(profil1);

            em.persist(user1); // CascadeType.ALL persiste aussi le profil


            //  Création Categorie + Produits

            Categorie catElectro = new Categorie("Électronique", "Appareils high-tech");

            Produit p1 = new Produit("Laptop HP", 899.99, 15);
            Produit p2 = new Produit("Souris sans fil", 29.99, 50);
            Produit p3 = new Produit("Clavier mécanique", 149.99, 20);

            catElectro.ajouterProduit(p1);
            catElectro.ajouterProduit(p2);
            catElectro.ajouterProduit(p3);

            em.persist(catElectro); // Cascade persiste automatiquement les produits


            //  Création Commande + Produits

            Commande commande1 = new Commande();
            commande1.setDateCommande(LocalDate.now());
            commande1.setStatut("EN_ATTENTE");

            // Ajouter des produits à la commande
            commande1.ajouterProduit(p1);
            commande1.ajouterProduit(p2);

            em.persist(commande1);

            em.getTransaction().commit();


            //  Affichage test

            System.out.println("Utilisateur créé : " + user1.getNom() + ", Profil : " + user1.getProfil().getBio());
            System.out.println("Catégorie : " + catElectro.getNom() + ", Produits : " + catElectro.getProduits().size());
            System.out.println("Commande total = " + commande1.getMontantTotal() + " €");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}


