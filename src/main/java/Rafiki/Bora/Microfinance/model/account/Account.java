package Rafiki.Bora.Microfinance.model.account;


import Rafiki.Bora.Microfinance.model.transactions.Transaction;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<<<<<<< Updated upstream
@Data
=======

>>>>>>> Stashed changes
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id",  columnDefinition = "INT(10)")
    private int id;

    @Column(name = "name",nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "account_number",nullable = false, unique = true, columnDefinition = "VARCHAR(10)")
    private String accountNumber;

    @Column(name = "pan",nullable = false, columnDefinition = "INT(19)")
    private int pan;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_created", nullable = false, updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @JsonBackReference(value = "created_by_a")
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false, referencedColumnName = "user_id")
    private User accountMaker;

    @JsonBackReference(value = "approved_by_a")
    @ManyToOne
    @JoinColumn(name="approved_by", referencedColumnName = "user_id")
    private User accountChecker;

    @JsonManagedReference(value = "account_number_u")
    @OneToOne(mappedBy="userAccount",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private User user;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean status;

    @Column(name = "balance", nullable = false, columnDefinition = "DOUBLE(12,2) DEFAULT 0.00")
    private double balance;

    @OneToMany(mappedBy="sourceAccount",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "source_account_t")
    private List<Transaction> withdrawals = new ArrayList<Transaction>();

    @OneToMany(mappedBy="destinationAccount",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "destination_account_t")
    private List<Transaction> deposits = new ArrayList<Transaction>();

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
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

    public User getAccountMaker() {
        return accountMaker;
    }

    public void setAccountMaker(User accountMaker) {
        this.accountMaker = accountMaker;
    }

    public User getAccountChecker() {
        return accountChecker;
    }

    public void setAccountChecker(User accountChecker) {
        this.accountChecker = accountChecker;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Transaction> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public List<Transaction> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Transaction> deposits) {
        this.deposits = deposits;
    }
}
