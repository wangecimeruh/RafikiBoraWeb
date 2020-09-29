package Rafiki.Bora.Microfinance.dao.agentDao;

import Rafiki.Bora.Microfinance.model.agents.Agent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AgentDao implements AgentDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Agent agents) {

    }

    @Override
    public void delete(Agent agents) {

    }
}