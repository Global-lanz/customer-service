package lanz.global.customerservice.service;

import lanz.global.customerservice.exception.BadRequestException;
import lanz.global.customerservice.external.api.company.CompanyClient;
import lanz.global.customerservice.external.api.company.response.CompanyResponse;
import lanz.global.customerservice.external.api.finance.FinanceClient;
import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyClient companyClient;
    private final FinanceClient financeClient;

    public CompanyResponse findCompanyById(UUID companyId) throws BadRequestException {
        if (companyId == null) {
            return null;
        }

        return companyClient.findCompanyById(companyId);
    }

    public CurrencyResponse findCurrencyById(UUID currencyId) throws BadRequestException {
        if (currencyId == null) {
            return null;
        }

        return financeClient.findCurrencyById(currencyId);
    }

}
