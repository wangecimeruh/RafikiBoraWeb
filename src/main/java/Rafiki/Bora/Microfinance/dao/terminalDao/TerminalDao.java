package Rafiki.Bora.Microfinance.dao.terminalDao;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.model.users.User;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.Checker;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class TerminalDao implements TerminalDaoI {
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
        String hql = "SELECT U FROM Terminal U";
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
     * @param id
     * @return
     * @throws Exception
     */
    public Terminal show(String id) throws Exception {
        return this.findById(id);
    }



    /**
     * save new terminal
     @param deleted
     @param usr
     @param mchnt
     * @throws Exception
     */


    public void create(Boolean deleted, String usr, String mchnt) throws Exception {

        int terminaluser = Integer.parseInt(usr);
        int terminalmerchant = Integer.parseInt(mchnt);

        try {
            this.terminal.isDeleted(deleted);

            User user = this.em.getReference(User.class, terminaluser);
            this.terminal.setChecker(user);

            Merchant merchant = this.em.getReference(Merchant.class, terminalmerchant);
            this.terminal.setMerchant(merchant);

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
     @param deleted
     @param usr
     @param mchnt
      * @throws Exception
     */


    public void update(String id, Boolean deleted, String usr, String mchnt) throws Exception{

        int terminaluser = Integer.parseInt(usr);
        int terminalmerchant = Integer.parseInt(mchnt);


        this.terminal = this.findById(id);

        try {
            this.terminal.isDeleted(deleted);

            User user = this.em.getReference(User.class, terminaluser);
            this.terminal.setChecker(user);

            Merchant merchant = this.em.getReference(Merchant.class, terminalmerchant);
            this.terminal.setMerchant(merchant);

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
     @param id
      * @throws Exception
     */




    public void delete(String id) throws Exception{
        try {
            this.terminal = this.findById(id);
            this.em.remove(this.terminal);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }



    /**
     * find new terminal
     @param id
      * @throws Exception
     */



    private Terminal findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid terminal id");

        try{
            Terminal terminal = this.em.find(Terminal.class, Integer.parseInt(id));
            if(terminal == null)
                throw new Exception("Terminal not found");
            else
                return terminal;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid terminal entity or primary key");
        }
    }
}
