package com.example.springbatch3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "GTT_TRANSACTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GttTransaction {
    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gtt_generator")
    @SequenceGenerator(name="gtt_generator", sequenceName = "SCQ_GTT", allocationSize = 1)
    private Long transactionId;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "CREDIT_ACCOUNT_NUMBER")
    private String creditAccountNumber;

    @Column(name = "DEBIT_ACCOUNT_NUMBER")
    private String debitAccountNumber;

    @Column(name = "CREDIT_AMOUNT")
    private BigDecimal creditAmount;

    @Column(name = "DEBIT_AMOUNT")
    private BigDecimal debitAmount;

    @Column(name = "COMPANY_ACCOUNT_ID")
    private Long companyAccountId;

    @Column(name = "TRX_REFERENCE")
    private String trxReference;

    @Column(name = "INSERT_BY")
    private Long insertBy;

    @Column(name = "AUTHORIZE_BY")
    private Long authorizeBy;

    @Column(name = "LAST_UPDATE_BY")
    private Long lastUpdateBy;

    @Column(name = "HOLD_BY")
    private Integer holdBy;

    @Column(name = "CANCEL_BY")
    private Long cancelBy;

    @Column(name = "DELETE_REASON")
    private String deleteReason;

    @Column(name = "HOLD_REASON")
    private String holdReason;

    @Column(name = "CANCEL_REASON")
    private String cancelReason;
    
    @Column(name = "API_RESPONSE")
    private String apiResponse;
    
    @Column(name = "TRANSACTION_CURRENCY_ID")
    private Integer transactionCurrencyId;
    
    @Column(name = "STATUS")
    private Integer status;
    
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    
    @Column(name = "PAYMENT_TYPE_ID")
    private Integer paymentTypeId;
    
    @Column(name = "INSTRUMENT_NUMBER")
    private String instrumentNumber;
    
    @Column(name = "INSTRUMENT_BANK")
    private Integer instrumentBank;
    
    @Column(name = "INSTRUMENT_BRANCH_NAME")
    private String instrumentBranchName;
    
    @Column(name = "TRX_REMARKS")
    private String trxRemarks;
    
    @Column(name = "PAYMENT_BY")
    private Integer paymentBy;
    
    @Column(name = "CLIENTKEY")
    private String clientKey;
    
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    
    @Column(name = "SETTLEMENT_STATUS")
    private Integer settlementStatus;
    
    @Column(name = "FILE_TRANS_STATUS")
    private Integer fileTransStatus;
    
    @Column(name = "ROUTING_NUMBER")
    private String routingNumber;
    
    @Column(name = "PAYMENT_THROUGH")
    private String paymentThrough;
    
    @Column(name = "FILE_ID")
    private Long fileId;
    
    @Column(name = "BENEFICIARY_ACCOUNT_ID")
    private Integer beneficiaryAccountId;
    
    @Column(name = "REASON")
    private String reason;
    
    @Column(name = "ACCOUNTTYPE")
    private String accountType;
    
    @Column(name = "RECEIVERID")
    private String receiverId;

    @Column(name = "RECEIVING_BRANCH")
    private Integer receivingBranch;
    
    @Column(name = "BEARER_NAME")
    private String bearerName;
    
    @Column(name = "BEARER_CONTACT")
    private String bearerContact;
    
    @Column(name = "POAMOUNT")
    private Integer poAmount;
    
    @Column(name = "VATAMOUNT")
    private Double vatAmount;
    
    @Column(name = "CHARGEAMOUNT")
    private Double chargeAmount;
    
    @Column(name = "FIN_CUSTOMER_NAME")
    private String finCustomerName;

    @Column(name = "APPROVER_HOLD_FLAG")
    private Integer approverHoldFlag;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "RECEIVER_EMAIL")
    private String receiverEmail;

    @Column(name = "SCHEDULER_FLAG")
    private Integer schedulerFlag;

    @Column(name = "REGISTRATION_YEAR")
    private Integer registrationYear;

    @Column(name = "REGISTRATION_NUMBER")
    private Integer registrationNumber;

    @Column(name = "DECLARANT_CODE")
    private Integer declarantCode;

    @Column(name = "CUSTOMS_OFFICE_CODE")
    private Integer customsOfficeCode;

    @Column(name = "DEPT")
    private Integer dept;

    @Column(name = "BKASHTXNID")
    private String bkashTxnId;

    @Column(name = "INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date insertDate;

    @Column(name = "AUTHORIZE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date authorizeDate;

    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateDate;

    @Column(name = "HOLD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date holdDate;

    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date cancelDate;

    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date paymentDate;
    
    @Column(name = "VALUE_DATE")
    Date valueDate;

    @Column(name = "BIN")
    private String bin;

    @Column(name = "COMMISSIONE_RATE")
    private String commisionRate;

    @Column(name = "ECONOMIC_CODE")
    private String economicCode;

    @Column(name = "CHALAN_DATE")
    private Date challanDate;

    @Column(name = "CHALAN_NO")
    private String challanNo;
}
