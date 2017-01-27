package dal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HybernateUtil {
    private static EntityManager entityManager;

    static{
        try {
            // Creation of the manager
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
            EntityManager theManager = factory.createEntityManager();
            entityManager = theManager;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void shutdown() {
        // Close caches and connection pools
        entityManager.close();
    }
}
