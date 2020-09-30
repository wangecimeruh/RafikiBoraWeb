package Rafiki.Bora.Microfinance.model.users;

import Rafiki.Bora.Microfinance.model.Person;
import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.agents.Agent;
import Rafiki.Bora.Microfinance.model.customers.Customer;
import Rafiki.Bora.Microfinance.model.groups.Group;
import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
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
    @ManyToOne
    @JoinColumn(name="group_id", nullable = false, referencedColumnName = "group_id")
    private Group group;


    @OneToMany(mappedBy="user",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Terminal> terminal = new ArrayList<Terminal>();


    @OneToMany(mappedBy="user",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Merchant> merchant = new ArrayList<Merchant>();

    @OneToMany(mappedBy="user",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Account> accounts = new ArrayList<Account>();

    @OneToMany(mappedBy="user",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Customer> customer = new ArrayList<Customer>();

    @OneToMany(mappedBy="user",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Agent> agent = new ArrayList<Agent>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Terminal> getTerminal() {
        return terminal;
    }

    public void setTerminal(List<Terminal> terminal) {
        this.terminal = terminal;
    }

    public List<Merchant> getMerchant() {
        return merchant;
    }

    public void setMerchant(List<Merchant> merchant) {
        this.merchant = merchant;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
