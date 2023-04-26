package com.calculator.calculator.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Class for creating entity manager factory
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;

    // There will only be one entityManagerFactory throughout the runtime of application (although there will be multiple sessions)
    // entityManagerFactory works with singleton pattern
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
