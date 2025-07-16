package lanz.global.customerservice.service;

import lanz.global.customerservice.external.api.finance.FinanceClient;
import lanz.global.customerservice.external.api.finance.request.GetContractParams;
import lanz.global.customerservice.external.api.finance.response.ContractResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FinanceService {

    private final FinanceClient financeClient;

    public boolean customerContainsLinkedContracts(UUID customerId) {
        GetContractParams params = new GetContractParams();
        params.setCustomerId(customerId);
        Page<ContractResponse> response = financeClient.findAllByFilter(params);

        return response.getTotalElements() > 0;
    }
}
