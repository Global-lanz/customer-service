package lanz.global.customerservice.service;

import jakarta.ws.rs.InternalServerErrorException;
import lanz.global.customerservice.external.api.company.response.CompanyResponse;
import lanz.global.customerservice.external.api.company.response.CurrencyResponse;
import lanz.global.customerservice.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {

    private final RestTemplate restTemplate;

    String URL = "http://company-service:8082/company";

    public CompanyResponse findCompanyById(UUID companyId) throws BadRequestException {
        if (companyId == null) {
            return null;
        }

        ResponseEntity<CompanyResponse> response = restTemplate.getForEntity(URL + "/" + companyId, CompanyResponse.class);

        return switch (response.getStatusCode()) {
            case HttpStatus.OK -> response.getBody();
            case HttpStatus.BAD_REQUEST -> throw new BadRequestException("Company");
            case null, default -> throw new InternalServerErrorException();
        };
    }

    public CurrencyResponse findCurrencyById(UUID currencyId) throws BadRequestException {
        if (currencyId == null) {
            return null;
        }

        ResponseEntity<CurrencyResponse> response = restTemplate.getForEntity(URL + "/currency/" + currencyId, CurrencyResponse.class);

        return switch (response.getStatusCode()) {
            case HttpStatus.OK -> response.getBody();
            case HttpStatus.BAD_REQUEST -> throw new BadRequestException("Currency");
            case null, default -> throw new InternalServerErrorException();
        };
    }

}
