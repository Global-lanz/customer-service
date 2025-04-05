package lanz.global.customerservice.util.converter;

import lanz.global.customerservice.api.response.CustomerResponse;
import lanz.global.customerservice.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerResponseConverter implements Converter<Customer, CustomerResponse> {
    @Override
    public CustomerResponse convert(Customer entity) {
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
                entity.getCurrencyId());
    }
}
