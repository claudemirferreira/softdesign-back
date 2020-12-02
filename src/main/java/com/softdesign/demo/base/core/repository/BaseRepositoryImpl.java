package com.softdesign.demo.base.core.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.lang.reflect.Method;
import java.util.*;

public class BaseRepositoryImpl<E> extends SimpleJpaRepository<E, UUID> implements BaseRepository<E> {

    private EntityManager em;

    public BaseRepositoryImpl(JpaEntityInformation<E, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        em = entityManager;
    }

    public BaseRepositoryImpl(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public Optional<E> findById(UUID id) {
        return Optional.ofNullable(em.find(getDomainClass(), id));
    }

    public E getById(UUID id) {
        E e = (E) em.find(getDomainClass(), id);
        if (e == null) {
            throw new EntityNotFoundException("the entity class " + getDomainClass().getName() + " with ID " + id + " was not found");
        }
        return e;
    }

    @SuppressWarnings("unchecked")
    public List<E> getByIds(Collection<UUID> ids) {
        Query query = em.createQuery("select x from " + getDomainClass().getSimpleName() + " x where x.id in (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    @Override
    public <S extends E> S save(S entity) {
        try {
            if (!em.contains(entity)) {
                this.em.persist(setCreatedAt(entity));
            }
            this.em.persist(setUpdatedAt(entity));
        } catch (Exception e) {
        }

        return super.save(entity);
    }

    public E softDelete(E e) {
        try {
            Method m = e.getClass().getMethod("setDeleted", boolean.class);
            m.invoke(e, true);
        } catch (Exception exception) {
            // exception.printStackTrace();
        }
        return save(e);
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        Query query = em.createQuery("select x from " + getDomainClass().getSimpleName() + " x where x.deleted = 0");
        return query.getResultList();
    }

    private E setUpdatedAt(E entity) {
        try {
            Method m = entity.getClass().getMethod("setUpdatedAt", Date.class);
            m.invoke(entity, new Date());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return entity;
    }


    private E setCreatedAt(E entity) {
        try {
            Method m = entity.getClass().getMethod("setCreatedAt", Date.class);
            m.invoke(entity, new Date());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return entity;
    }


}

