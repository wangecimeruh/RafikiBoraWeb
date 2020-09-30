package Rafiki.Bora.Microfinance.model.customers;


import Rafiki.Bora.Microfinance.model.Person;
import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;

    @Embedded
    private Person person;

    @Column(name = "phone_number",nullable = false, columnDefinition = "VARCHAR(10)")
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
