package Rafiki.Bora.Microfinance.model.users;

import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.groups.Group;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", columnDefinition = "INT(10)")
    private int id;

    @Column(name = "first_name",nullable = false, columnDefinition = "VARCHAR(15)")
    private String firstName;

    @Column(name = "last_name",nullable = false, columnDefinition = "VARCHAR(15)")
    private String lastName;

    @Column(name = "email",nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "password",nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "status",nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean status;

    @Column(name = "mid", unique = true, columnDefinition = "VARCHAR(34)")
    private String mid;

    @Column(name = "business_name", columnDefinition = "VARCHAR(35)")
    private String business_name;

    @Column(name = "phone_no", nullable = false, columnDefinition = "VARCHAR(10)")
    private String phone_no;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_created", updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false, referencedColumnName = "user_id")
    private User userMaker;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy="userMaker", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonManagedReference
//    private List<User> createdUsers = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="approved_by", referencedColumnName = "user_id")
    private User userChecker;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy="userChecker", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonManagedReference
//    private List<User> approvedUsers = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false, referencedColumnName = "role_id")
    private Group group;

//    @OneToMany(mappedBy="terminalMaker", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Terminal> createdTerminals = new ArrayList<Terminal>();
//
//    @OneToMany(mappedBy="terminalChecker",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Terminal> approvedTerminals = new ArrayList<Terminal>();

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="account_number", referencedColumnName = "account_id")
    private Account userAccount;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy="accountMaker", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonManagedReference
//    private List<Account> createdAccounts = new ArrayList<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy="accountChecker", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonManagedReference
//    private List<Account> approvedAccounts = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "Agents_Terminals",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "terminal_id") }
    )
    List<Terminal> assignedTerminals = new ArrayList<Terminal>();

}



