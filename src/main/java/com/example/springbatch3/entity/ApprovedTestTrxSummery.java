package com.example.springbatch3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "APPROVED_TRX_SUMMERY")
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApprovedTestTrxSummery {

    @Id
    @Column(name = "TRANSACTION_REFERENCE")
    private String transactionReference;



    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "TOTAL_TRX")
    private int totalTrx;

    @Column(name = "DR_ACCOUNT")
    private String drAccount;

    @Column(name = "CR_ACCOUNT")
    private String crAccount;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "PAYMENT_TYPE_ID")
    private Long paymentTypeId;

}
