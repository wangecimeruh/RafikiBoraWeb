package Rafiki.Bora.Microfinance.model.account;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.model.transactions.Transaction;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int id;

    @Column(name = "name",nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "pan",nullable = false, columnDefinition = "INT(19)")
    private int pan;

    @Column(name = "phone_number",nullable = false, columnDefinition = "VARCHAR(10)")
    private String phoneNumber;

    @Column(name = "account_number",nullable = false, columnDefinition = "VARCHAR(28)")
    private String accountNumber;

    @Column(name = "is_deleted",nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_added", nullable = false, updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false, columnDefinition = "DATETIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

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

    @OneToMany(mappedBy="account",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<Transaction>();

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Merchant merchant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
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
