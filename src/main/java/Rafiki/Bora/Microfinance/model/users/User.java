package Rafiki.Bora.Microfinance.model.users;

import Rafiki.Bora.Microfinance.config.security.dto.UserSummary;
import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
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

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_created", updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
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
    @OneToOne
    @JoinColumn(name="account_number", referencedColumnName = "account_id")
    private Account userAccount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "Agents_Terminals",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "terminal_id") }
    )
    List<Terminal> assignedTerminals = new ArrayList<Terminal>();

}



