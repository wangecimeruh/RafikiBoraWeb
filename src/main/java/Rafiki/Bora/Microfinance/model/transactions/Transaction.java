package Rafiki.Bora.Microfinance.model.transactions;

import Rafiki.Bora.Microfinance.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name="reference_no", columnDefinition = "VARCHAR(12)")
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="pan", nullable = false, referencedColumnName = "pan")
    private Account pan;

    @Column(name = "processing_code", columnDefinition = "VARCHAR(6)")
    private String processingCode;

    @Column(name = "amount_transaction",columnDefinition = "DOUBLE(12,2)")
    private double amountTransaction;

    @Column(name = "amount_reconciliation",columnDefinition = "DOUBLE(12,2)")
    private double amountReconciliation;

    @Column(name = "amount_cardholder_billing",columnDefinition = "DOUBLE(12,2)")
    private double amountCardholderBilling;

    @Column(name = "amount_transaction_currency_code",columnDefinition = "VARCHAR(3)")
    private String amountTransactionCurrencyCode;

    @Column(name = "amount_reconciliation_currency_code",columnDefinition = "VARCHAR(3)")
    private String amountReconciliationCurrencyCode;

    @Column(name = "amount_cardholder_billing_currency_code",columnDefinition = "VARCHAR(3)")
    private String amountCardholderBillingCurrencyCode;

    @Column(name = "date_time_transmission", updatable=false, columnDefinition = "DATETIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateTimeTransmission;

    @Column(name = "stan",columnDefinition = "INT(12)")
    private int stan;

    @Column(name = "date_time_local_transaction", updatable=false, columnDefinition = "DATETIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateTimeLocalTransaction;

    @Column(name = "expiration_date",columnDefinition = "INT(4)")
    private int expirationDate;

    @Column(name = "settlement_date",columnDefinition = "INT(8)")
    private int settlementDate;

    @Column(name = "capture_date",columnDefinition = "INT(4)")
    private int captureDate;

    @Column(name = "acquiring_institution_code",columnDefinition = "INT(11)")
    private int acquiringInstitutionCode;

    @Column(name = "approval_code",columnDefinition = "VARCHAR(6)")
    private String approvalCode;

    @Column(name = "result_code",columnDefinition = "VARCHAR(6)")
    private String resultCode;

    @Column(name = "tid",columnDefinition = "VARCHAR(16)")
    private String tid;

    @Column(name = "mid",columnDefinition = "VARCHAR(34)")
    private String mid;

    @Column(name = "source_account",columnDefinition = "VARCHAR(28)")
    private String sourceAccount;

    @Column(name = "destination_account",columnDefinition = "VARCHAR(28)")
    private String destinationAccount;
}
