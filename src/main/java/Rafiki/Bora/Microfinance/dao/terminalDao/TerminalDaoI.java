package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.dto.TerminalDto;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;

import java.util.List;

public interface TerminalDaoI {
        public List<Terminal> list() throws Exception;
        public Terminal show(String tid) throws Exception;
        public void create(TerminalDto terminalDto, String tid, int makerId) throws Exception;
        public void update(String tid, int checkerId) throws Exception;
        public void delete(String tid) throws Exception;
    }

