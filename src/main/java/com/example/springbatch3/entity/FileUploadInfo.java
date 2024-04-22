package com.example.springbatch3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CORP_FILE_UPLOAD_INFO")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadInfo {

    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "file_upload_generator")
    @SequenceGenerator(name="file_upload_generator", sequenceName = "SCQ_UPLOAD_FILE", allocationSize = 1)
    private Long fileId;
    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "TRANSACTION_REF", nullable = true)
    private String transactionReference;



    @Column(name = "PAYMENT_TYPE_ID")
    private Integer payTypeId;
}
