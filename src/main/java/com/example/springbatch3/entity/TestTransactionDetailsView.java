package com.example.springbatch3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vw_transaction_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestTransactionDetailsView {
    @Id
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;


    @Column(name = "TRX_REFERENCE")
    private String transactionReference;


}
