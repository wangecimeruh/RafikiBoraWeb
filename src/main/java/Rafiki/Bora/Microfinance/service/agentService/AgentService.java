package Rafiki.Bora.Microfinance.service.agentService;

import Rafiki.Bora.Microfinance.dao.agentDao.AgentDaoI;
import Rafiki.Bora.Microfinance.model.agents.Agent;
import org.springframework.beans.factory.annotation.Autowired;

public class AgentService {
    @Autowired
    private AgentDaoI dao;

    public void save(Agent agents) throws Exception{
        dao.save(agents);

    }
}
