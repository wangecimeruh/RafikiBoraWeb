package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.dto.TerminalDto;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.model.users.User;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.Checker;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.Date;
import java.util.List;

@Repository
public class TerminalDao implements TerminalDaoI{
    @PersistenceContext
    private EntityManager em;

    //CRUD function

    Terminal terminal = new Terminal();

    /**
     * List terminal
     *
     * @return
     * @throws Exception
     */
    public List<Terminal> list() throws Exception {
        String hql = "SELECT T FROM Terminal T";
        try {
            return this.em.createQuery(hql).getResultList();
        } catch (IllegalArgumentException ex) {
            throw new Exception("Invalid query");
        } catch (NoResultException ex) {
            throw new Exception("No Terminal found");
        }
    }

    /**
     * Show terminal by id
     *
     * @param tid
     * @return
     * @throws Exception
     */
    public Terminal show(String tid) throws Exception {
        return this.findById(tid);
    }


    /**
     *
     * @param tid
     * @param makerId
     * @throws Exception
     */
    public void create(TerminalDto terminalDto, String tid, int makerId) throws Exception {
        try {
            this.terminal.setTid(tid);
            this.terminal.setDateCreated(new Date());
            this.terminal.setDeleted(false);
            this.terminal.setStatus(false);
            this.terminal.setDateUpdated(new Date());

            // maker of terminal
            User maker = this.em.getReference(User.class, makerId);
            this.terminal.setTerminalMaker(maker);

            this.em.merge(this.terminal);
        } catch (EntityExistsException ex) {
            throw new Exception(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new Exception(ex.getMessage());
        } catch (TransactionalException ex) {
            throw new Exception(ex.getMessage());
        } catch (EntityNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }


    /**
     * update new terminal
     @param tid
      * @throws Exception
     */

    public void update(String tid, int checkerId) throws Exception{

        try {
            this.terminal.setTid(tid);
            this.terminal.setDateUpdated(new Date());
            this.terminal.setStatus(true);

            User checker = this.em.getReference(User.class, checkerId);
            this.terminal.setTerminalMaker(checker);

            this.em.merge(this.terminal);
        }catch (EntityExistsException ex){
            throw new Exception(ex.getMessage());
        }catch(IllegalArgumentException ex){
            throw new Exception(ex.getMessage());
        }catch(TransactionalException ex){
            throw new Exception(ex.getMessage());
        }catch (EntityNotFoundException ex){
            throw new Exception(ex.getMessage());
        }
    }


    /**
     * delete new terminal
     @param tid
      * @throws Exception
     */




    public void delete(String tid) throws Exception{
        try {
            this.terminal = this.findById(tid);
            this.em.remove(this.terminal);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }



    /**
     * find new terminal
     @param tid
      * @throws Exception
     */




    private Terminal findById(String tid) throws Exception{
        if(StringUtils.isBlank(tid) || StringUtils.equalsIgnoreCase(tid, "0"))
            throw new Exception("Invalid terminal id");

        try{
            Terminal terminal = this.em.find(Terminal.class, Integer.parseInt(tid));
            if(terminal == null)
                throw new Exception("Terminal not found");
            else
                return terminal;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid terminal entity or primary key");
        }
    }
}

