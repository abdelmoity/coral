package io.coral.contacts.model.repository.impl;

import io.coral.contacts.model.domain.AbstractEntity;
import io.coral.contacts.model.repository.BasicRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BasicRepositoryImpl implements BasicRepository {
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        init();
        return emf.createEntityManager();
    }

    @PostConstruct
    public void init(){
        System.out.println(".............");
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("customersPU");
        }
    }

    public AbstractEntity add(AbstractEntity entity){
        EntityManager em=null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
           return entity;
        } catch ( Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

    public AbstractEntity update(AbstractEntity entity){
        EntityManager em=null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch ( Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

    public AbstractEntity delete(AbstractEntity entity){
        EntityManager em=null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           if (em.contains(entity)){
               em.remove(entity);
           }
            em.getTransaction().commit();
            return entity;
        } catch ( Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

    public List<AbstractEntity> findAll(String entity,int offset,int maxSize){
        EntityManager em=null;
        try {
            em = getEntityManager();
            List<AbstractEntity> list=  em.createNamedQuery(entity+".findAll").setFirstResult(offset).setMaxResults(maxSize).getResultList();
            return list;
        } catch ( Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }





}
