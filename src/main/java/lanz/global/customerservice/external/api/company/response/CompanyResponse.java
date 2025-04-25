package lanz.global.customerservice.external.api.company.response;

import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;

import java.util.UUID;

public record CompanyResponse(
        UUID companyId,
        String name,
        String country,
        CurrencyResponse currency) {
}
