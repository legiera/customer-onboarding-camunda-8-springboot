package io.camunda.workshop.customer.process;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BankAccountFactory {

    private static Logger logger = LoggerFactory.getLogger(BankAccountFactory.class);

    @JobWorker(type="createNewBankAccount")
    public Map<String, Object> createNewBankAccount() {
        HashMap<String, Object> resultVariables = new HashMap<>();

        logger.info("Creating account ...");
        resultVariables.put("account created", true);

        return resultVariables;
    }

}
