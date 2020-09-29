package Rafiki.Bora.Microfinance.dao.rolesDao;

import Rafiki.Bora.Microfinance.model.roles.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RolesDao implements RolesDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Role roles) {

        em.merge(roles);
    }
    @Override
    public void delete(Role roles) {
        em.remove(roles);
    }
}
