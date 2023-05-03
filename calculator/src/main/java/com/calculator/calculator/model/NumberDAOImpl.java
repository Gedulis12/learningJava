package com.calculator.calculator.model;

import com.calculator.calculator.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class NumberDAOImpl implements NumberDAO {
    @Override
    public void insertEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(number);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Number findEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Number> numbers = entityManager
                // using ORM we're querying entities and not db tables
                .createQuery("SELECT n FROM Number n WHERE n.id = :id")
                .setParameter("id", id)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return numbers.get(0);
    }

    @Override
    public List<Number> findEntities() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Number> numbers = entityManager
                .createQuery("SELECT n FROM Number n")
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return numbers;
    }

    @Override
    public void updateEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // In order to update an entry we need to find it first in the database
        Number numberDB = entityManager.find(Number.class, number.getId());
        numberDB.setN1(number.getN1());
        numberDB.setN2(number.getN2());
        numberDB.setOperation(number.getOperation());
        numberDB.setResult(number.getResult());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Number numberDB = entityManager.find(Number.class, id);
        entityManager.remove(numberDB);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}