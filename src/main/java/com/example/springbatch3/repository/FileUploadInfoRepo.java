package com.example.springbatch3.repository;



import com.example.springbatch3.entity.FileUploadInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadInfoRepo extends JpaRepository<FileUploadInfo, Long> {



  FileUploadInfo findByTransactionReference(String trxRef);
}
