package org.pretest.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Stateless(name = "EntityBeanEJB")
@LocalBean
public class EntityBean<T extends Serializable> implements EntityService<T> {
    private final EntityManager entityManager;
    private Class<T> type;

    public void setType(Class<T> type) {
        this.type = type;
    }

    public EntityBean() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("companyPersistenceUnit");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public List<T> getEntities() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);
        return this.entityManager.createQuery(query).getResultList();
    }

    @Override
    public T getEntityById(String id) {
        return this.entityManager.find(type, id);
    }

    @Override
    public boolean addEntity(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean updateEntity(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean deleteEntity(String id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getEntityById(id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
