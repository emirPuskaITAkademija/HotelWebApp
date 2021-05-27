package com.solutions.best.app.entity.service;

import com.solutions.best.app.entity.Privilege;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class PrivilegeService {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager _em;

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Privilege create(Privilege entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Privilege read(Object id) {
        return getEntityManager().find(Privilege.class, id);
    }

    public Privilege update(Privilege entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Privilege entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return managed entity
     */
    public Privilege save(Privilege entity) {        
        if (entity.getId() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Privilege> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().
                createQuery();
        cq.select(cq.from(Privilege.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
