package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.model.terminal.Terminal;

import java.util.List;

public interface TerminalDaoI {
        public List<Terminal> list() throws Exception;
        public Terminal show(String id) throws Exception ;
        public void create(Boolean deleted, String usr, String mchnt) throws Exception;
        public void update(String id, Boolean deleted, String usr, String mchnt) throws Exception;
        public void delete(String id) throws Exception;
    }

