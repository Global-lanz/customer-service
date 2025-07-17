package lanz.global.customerservice.service;

import lanz.global.customerservice.external.api.finance.FinanceClient;
import lanz.global.customerservice.external.api.finance.request.GetContractParams;
import lanz.global.customerservice.external.api.finance.response.ContractResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FinanceService {

    private final FinanceClient financeClient;

    public boolean customerContainsLinkedContracts(UUID customerId) {
        GetContractParams params = new GetContractParams();
        params.setCustomerId(customerId);
        log.debug("Searching for contracts linked to customer with ID: {}", customerId);
        Page<ContractResponse> response = financeClient.findAllByFilter(params);

        log.debug("Contracts {}", response.getTotalElements());
        return response.getTotalElements() > 0;
    }
}
