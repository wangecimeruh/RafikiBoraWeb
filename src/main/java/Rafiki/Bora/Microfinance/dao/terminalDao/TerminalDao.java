package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TerminalDao implements TerminalDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Terminal terminal) {

        em.merge(terminal);
    }
    @Override
    public void delete(Terminal terminal) {
        em.remove(terminal);
    }
}
