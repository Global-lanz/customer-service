package lanz.global.customerservice.util.converter;

import lanz.global.customerservice.api.request.customer.CustomerRequest;
import lanz.global.customerservice.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerRequestConverter implements Converter<CustomerRequest, Customer> {

    @Override
    public Customer convert(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setTaxIdentificationNumber(request.taxIdentificationNumber());
        customer.setTaxIdentificationType(request.taxIdentificationType());
        customer.setTaxRegime(request.taxRegime());
        customer.setAnnualRevenue(request.annualRevenue());
        customer.setCountry(request.country());
        customer.setAddress(request.address());
        customer.setPostalCode(request.postalCode());
        customer.setBusinessSector(request.businessSector());
        customer.setEstablishmentDate(request.establishmentDate());
        customer.setNotes(request.notes());
        customer.setCurrencyId(request.currencyId());
        return customer;
    }

}
