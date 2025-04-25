package lanz.global.customerservice.external.api.finance;

import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "FINANCE-SERVICE")
public interface FinanceClient {

    @GetMapping("/finance/currency/{currencyId}")
    CurrencyResponse findCurrencyById(@PathVariable UUID currencyId);
}
