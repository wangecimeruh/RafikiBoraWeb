package Rafiki.Bora.Microfinance.model.users;

import Rafiki.Bora.Microfinance.config.security.dto.UserSummary;
import Rafiki.Bora.Microfinance.model.account.Account;
<<<<<<< Updated upstream
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import Rafiki.Bora.Microfinance.model.roles.Role;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> Stashed changes

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

<<<<<<< Updated upstream
@Data
=======

>>>>>>> Stashed changes
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", columnDefinition = "INT(10)")
    private Long userId;

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
    private String businessName;

    @Column(name = "phone_no", nullable = false, columnDefinition = "VARCHAR(10)")
    private String phoneNo;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_created", updatable=false, nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @JsonBackReference(value = "createdBy_u")
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false, referencedColumnName = "user_id")
    private User userMaker;

    @JsonBackReference(value = "approved_by_u")
    @ManyToOne
    @JoinColumn(name="approved_by", referencedColumnName = "user_id")
    private User userChecker;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

<<<<<<< Updated upstream
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "roleId")})
    private Set<Roles> roles;

    public UserSummary toUserSummary() {
        UserSummary userSummary = new UserSummary();
        userSummary.setEmail(this.email);
        userSummary.setUserId(this.userId);
        return userSummary;
    }

    @JsonBackReference(value = "account_number_u")
=======
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false, referencedColumnName = "role_id")
    private Role role;

//    @OneToMany(mappedBy="terminalMaker", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Terminal> createdTerminals = new ArrayList<Terminal>();
//
//    @OneToMany(mappedBy="terminalChecker",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Terminal> approvedTerminals = new ArrayList<Terminal>();

    @JsonBackReference
>>>>>>> Stashed changes
    @OneToOne
    @JoinColumn(name="account_number", referencedColumnName = "account_number")
    private Account userAccount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "Agents_Terminals",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "terminal_id") }
    )
    List<Terminal> assignedTerminals = new ArrayList<Terminal>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
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

    public User getUserMaker() {
        return userMaker;
    }

    public void setUserMaker(User userMaker) {
        this.userMaker = userMaker;
    }

    public User getUserChecker() {
        return userChecker;
    }

    public void setUserChecker(User userChecker) {
        this.userChecker = userChecker;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public List<Terminal> getAssignedTerminals() {
        return assignedTerminals;
    }

    public void setAssignedTerminals(List<Terminal> assignedTerminals) {
        this.assignedTerminals = assignedTerminals;
    }
}



