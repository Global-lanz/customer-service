package lanz.global.customerservice.util.converter;

import lanz.global.customerservice.api.request.CustomerRequest;
import lanz.global.customerservice.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerRequestConverter implements BaseConverter<CustomerRequest, Customer> {

    @Override
    public Customer convertToDto(CustomerRequest entity) {
        Customer customer = new Customer();
        customer.setName(entity.name());
        customer.setTaxIdentificationNumber(entity.taxIdentificationNumber());
        customer.setTaxIdentificationType(entity.taxIdentificationType());
        customer.setTaxRegime(entity.taxRegime());
        customer.setAnnualRevenue(entity.annualRevenue());
        customer.setCountry(entity.country());
        customer.setAddress(entity.address());
        customer.setPostalCode(entity.postalCode());
        customer.setBusinessSector(entity.businessSector());
        customer.setEstablishmentDate(entity.establishmentDate());
        customer.setNotes(entity.notes());
        return customer;
    }

}
