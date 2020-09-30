package Rafiki.Bora.Microfinance.model.merchant;

import Rafiki.Bora.Microfinance.model.Person;
import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @Column(name="mid", columnDefinition = "VARCHAR(34)")
    private int id;

    @Embedded
    private Person person;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false, referencedColumnName = "user_id")
    private User maker;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="approved_by", nullable = false, referencedColumnName = "user_id")
    private User checker;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="account_number", nullable = false, referencedColumnName = "account_number")
    private Account account;

    @OneToMany(mappedBy="merchant",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Terminal> terminal = new ArrayList<Terminal>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, referencedColumnName = "user_id")
    private User user;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User getMaker() {
        return maker;
    }

    public void setMaker(User maker) {
        this.maker = maker;
    }

    public User getChecker() {
        return checker;
    }

    public void setChecker(User checker) {
        this.checker = checker;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
