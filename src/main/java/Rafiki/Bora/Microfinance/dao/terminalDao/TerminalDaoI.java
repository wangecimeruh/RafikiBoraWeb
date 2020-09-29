package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.model.terminal.Terminal;

public interface TerminalDaoI {
    void save(Terminal terminal);
    void delete(Terminal terminal);
}
