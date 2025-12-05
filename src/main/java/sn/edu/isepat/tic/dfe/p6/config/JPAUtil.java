package sn.edu.isepat.tic.dfe.p6.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gestionPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

