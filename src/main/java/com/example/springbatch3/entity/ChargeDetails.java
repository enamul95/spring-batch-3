package com.example.springbatch3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CORP_CHARGE_DETAILS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargeDetails {

    @Id
    @Column(name = "ID", unique = true,nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "PAYMENT_TYPE")
    private Integer paymentType;



}
