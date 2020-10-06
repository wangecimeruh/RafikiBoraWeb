package Rafiki.Bora.Microfinance.model.terminal;



import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.transactions.Transaction;
import Rafiki.Bora.Microfinance.model.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "terminals")
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="terminal_id", columnDefinition = "INT(10)")
    private int id;

    @Column(name = "tid",nullable = false, unique = true, columnDefinition = "VARCHAR(16)")
    private String tid;

    @Column(name = "status", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="mid", referencedColumnName = "mid")
    private User merchant;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false, referencedColumnName = "user_id")
    private User terminalMaker;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="approved_by", referencedColumnName = "user_id")
    private User terminalChecker;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "date_added", updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, referencedColumnName = "user_id")
    private User user;


    @OneToMany(mappedBy="terminal",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<Transaction>();

}
