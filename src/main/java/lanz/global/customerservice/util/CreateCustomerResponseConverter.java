package lanz.global.customerservice.util;

import lanz.global.customerservice.api.response.CustomerResponse;
import lanz.global.customerservice.service.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerResponseConverter implements BaseConverter<Customer, CustomerResponse> {
    @Override
    public CustomerResponse convertToDto(Customer entity) {
        return new CustomerResponse(entity.getCustomerId(),
                entity.getName(),
                entity.getTaxIdentificationNumber(),
                entity.getTaxIdentificationType(),
                entity.getTaxRegime(),
                entity.getAnnualRevenue(),
                entity.getCountry(),
                entity.getAddress(),
                entity.getPostalCode(),
                entity.getBusinessSector(),
                entity.getEstablishmentDate(),
                entity.getNotes(),
                entity.getCurrency() != null ? entity.getCurrency().getCurrencyId() : null);
    }
}
