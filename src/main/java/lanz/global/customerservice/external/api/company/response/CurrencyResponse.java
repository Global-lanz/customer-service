package lanz.global.customerservice.external.api.company.response;

import java.util.UUID;

public record CurrencyResponse(UUID currencyId,
                               String name,
                               String code,
                               String symbol) {
}
