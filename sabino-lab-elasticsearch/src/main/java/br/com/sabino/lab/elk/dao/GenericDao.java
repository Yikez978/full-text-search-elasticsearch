package br.com.sabino.lab.elk.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Stateless
public abstract class GenericDao<T, I extends Serializable> {

    @PersistenceContext(unitName = "elk-persistence-unit")
    protected EntityManager em;

    private Class<T> entityClass;

    protected GenericDao() {
    }

    protected GenericDao(Class<T> entityClass) {
        this();
        this.entityClass = entityClass;
    }

    public T save(@Valid T entity) {
        em.persist(entity);
        return entity;
    }

    public T update(@Valid T entity) {
        em.merge(entity);
        return entity;
    }

    public void remove(I id) {
        T entity = findById(id);
        if (entity != null) em.remove(em.merge(entity));
    }

    public T findById(I id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        return em.createQuery(query.select(query.from(entityClass))).getResultList();
    }

    public List<T> findAllPaged(Integer startPosition, Integer maxResult) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        TypedQuery<T> typedQuery = em.createQuery(query.select(query.from(entityClass)));

        if (startPosition != null) {
            typedQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            typedQuery.setMaxResults(maxResult);
        }
        return typedQuery.getResultList();
    }
}