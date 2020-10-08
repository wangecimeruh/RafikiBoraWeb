
package Rafiki.Bora.Microfinance.service.terminalService;

import Rafiki.Bora.Microfinance.dao.terminalDao.TerminalDaoI;
import Rafiki.Bora.Microfinance.dto.TerminalDto;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TerminalService {

    @Autowired
    private TerminalDaoI dao;


    public List<Terminal> list()  throws Exception{
        return dao.list();
    }

    public Terminal show(String tid) throws Exception{
        return dao.show(tid);
    }

    public void create(TerminalDto terminalDto) throws Exception{
        String tid ="rtyg1458";
        int makerId = 1;
        dao.create(terminalDto, tid, makerId);
    }

    public void update(String tid)throws Exception{
        int checkerId = 1;
        dao.update(tid, checkerId);
    }

    public void delete(String tid)  throws Exception{
        dao.delete(tid);
    }

}




