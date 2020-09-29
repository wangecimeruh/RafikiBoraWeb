package Rafiki.Bora.Microfinance.dao.agentDao;

import Rafiki.Bora.Microfinance.model.agents.Agent;

public interface AgentDaoI {

    void save(Agent agent);
    void delete(Agent agent);

}