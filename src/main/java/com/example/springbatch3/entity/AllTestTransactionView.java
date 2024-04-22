package com.example.springbatch3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VW_ALL_APPROVED_TANSACTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllTestTransactionView {

    @Id
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;



}
