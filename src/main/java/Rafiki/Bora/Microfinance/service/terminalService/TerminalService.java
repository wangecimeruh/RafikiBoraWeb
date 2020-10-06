package Rafiki.Bora.Microfinance.service.terminalService;

import Rafiki.Bora.Microfinance.dao.terminalDao.TerminalDaoI;
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
    /**
     *
     * parentClass childClassInstance = new childClass();
     *
     * childClass childClassInstance = new parentClass();
     *
     * When a child extends parent class, child class might can override parent methods
     *
     * class Parent {
     *     void showName(){
     *         // print name
     *     }
     * }
     *
     * class Child extends Parent{
     *     void showName(){
     *         // print name
     *     }
     *
     *     void showName(){
     *         // print number
     *     }
     * }
     *
     * Parent childInstance = new  Child();
     * child.showName();
     *
     * Child childInstance = new Child();
     * child.showName();
     *
     * Child parentInstance = new Parent();
     * parentInstance.showName();
     *
     */

    public List<Terminal> list()  throws Exception{
        return dao.list();
    }

    public Terminal show(String id)  throws Exception{
        return dao.show(id);
    }
    public void create(Boolean deleted, String user, String merchant) throws Exception{
        dao.create(deleted, user, merchant);
    }

    public void update(String id, Boolean deleted, String user, String merchant) throws Exception{
        dao.update(id, deleted, user, merchant);
    }

    public void delete(String id)  throws Exception{
        dao.delete(id);
    }

}

