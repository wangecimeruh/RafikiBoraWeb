package Rafiki.Bora.Microfinance.service.terminalService;

import Rafiki.Bora.Microfinance.dao.terminalDao.TerminalDaoI;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;

public class TerminalService {
    @Autowired
    private TerminalDaoI dao;

    public void save(Terminal terminal) throws Exception {

            dao.save(terminal);


    }
}
