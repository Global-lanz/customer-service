package lanz.global.customerservice.external.api.finance.response;

import java.util.UUID;

public record CurrencyResponse(UUID currencyId,
                               String name,
                               String code,
                               String symbol) {
}
