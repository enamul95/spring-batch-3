package com.example.springbatch3.procedurecall;


import com.example.springbatch3.payload.response.MarkAsHoldResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TransactionSPcall {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${db.name}")
    private String DATABASE_NAME;

    public MarkAsHoldResponse updateBulkReference(String xml) {
        MarkAsHoldResponse response = new MarkAsHoldResponse();


        log.info("updateBulkReference updateBulkReference = " + xml);

        try {

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery(DATABASE_NAME+".PKG_TRANSACTION.updateBulkReference");
            query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);

            query.setParameter(1, xml);
            query.execute();

            response.setOutCode((Integer) query.getOutputParameterValue(2));
            response.setOutMessage((String) query.getOutputParameterValue(3));

               } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }


}
