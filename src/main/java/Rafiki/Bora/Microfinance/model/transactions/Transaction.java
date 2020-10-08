package Rafiki.Bora.Microfinance.model.transactions;

import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


<<<<<<< Updated upstream
@Data
=======

>>>>>>> Stashed changes
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @Column(name="transaction_id", columnDefinition = "INT(10)")
    private int id;

    @JsonBackReference(value = "source_account_t")
    @ManyToOne
    @JoinColumn(name="source_account", referencedColumnName = "account_number")
    private Account sourceAccount;

    @JsonBackReference(value = "destination_account_t")
    @ManyToOne
    @JoinColumn(name="destination_account", referencedColumnName = "account_number")
    private Account destinationAccount;

    @JsonBackReference(value = "tid_t")
    @ManyToOne
    @JoinColumn(name="tid", nullable = false, referencedColumnName = "tid")
    private Terminal terminal;

    @Column(name = "processing_code", nullable=false, columnDefinition = "VARCHAR(6)")
    private String processingCode;

    @Column(name = "token", columnDefinition = "VARCHAR(10)")
    private String token;

    @Column(name = "amount_transaction", nullable=false, columnDefinition = "DOUBLE(12,2)")
    private double amountTransaction;

    @Column(name = "amount_transaction_currency_code", nullable=false, columnDefinition = "VARCHAR(3)")
    private String amountTransactionCurrencyCode;

    @Column(name = "date_time_local_transaction", updatable=false, nullable=false, columnDefinition = "DATETIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateTimeLocalTransaction;

    @Column(name = "result_code",columnDefinition = "VARCHAR(6)")
    private String resultCode;

<<<<<<< Updated upstream
=======
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(double amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getAmountTransactionCurrencyCode() {
        return amountTransactionCurrencyCode;
    }

    public void setAmountTransactionCurrencyCode(String amountTransactionCurrencyCode) {
        this.amountTransactionCurrencyCode = amountTransactionCurrencyCode;
    }

    public Date getDateTimeLocalTransaction() {
        return dateTimeLocalTransaction;
    }

    public void setDateTimeLocalTransaction(Date dateTimeLocalTransaction) {
        this.dateTimeLocalTransaction = dateTimeLocalTransaction;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
>>>>>>> Stashed changes
}
