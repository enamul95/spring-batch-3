package com.example.springbatch3.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "CORP_APPROVED_TRANSACTION")
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestApprovedTransaction {


    @Id
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;



    @Column(name = "TRX_REFERENCE")
    private String transactionReference;



    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;


    @Column(name = "PAYMENT_TYPE_ID")
    private Long paymentTypeId;


}

