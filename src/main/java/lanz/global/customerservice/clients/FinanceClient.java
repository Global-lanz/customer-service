package lanz.global.customerservice.clients;

import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "FINANCE-SERVICE")
public interface FinanceClient {

    @GetMapping("/finance/currency/{currencyId}")
    ResponseEntity<CurrencyResponse> findCurrencyById(@PathVariable UUID currencyId);
}
