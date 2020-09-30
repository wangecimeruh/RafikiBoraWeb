package Rafiki.Bora.Microfinance.model.agents;


import Rafiki.Bora.Microfinance.model.Person;

import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agent_id")
    private int id;

    @Embedded
    private Person person;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="tid", nullable = false, referencedColumnName = "tid")
    private Terminal terminal;

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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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
}


