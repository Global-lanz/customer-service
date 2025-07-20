package lanz.global.customerservice.external.api.finance;

import lanz.global.customerservice.external.api.finance.response.ContractResponse;
import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "FINANCE-SERVICE")
public interface FinanceClient {

    @GetMapping("/finance/currency/{currencyId}")
    CurrencyResponse findCurrencyById(@PathVariable UUID currencyId);

    @GetMapping(value = "/finance/contract/search")
    Page<ContractResponse> findAllByFilter(@RequestParam UUID customerId,
                                           @RequestParam Integer pageNumber,
                                           @RequestParam Integer pageSize);

}
