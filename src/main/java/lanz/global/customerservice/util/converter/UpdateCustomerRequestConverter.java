package lanz.global.customerservice.util.converter;

import lanz.global.customerservice.api.request.customer.CustomerRequest;
import lanz.global.customerservice.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerRequestConverter implements Converter<UpdateSourceTarget<CustomerRequest, Customer>, Customer> {

    @Override
    public Customer convert(UpdateSourceTarget<CustomerRequest, Customer> request) {
        Customer target = request.target();
        CustomerRequest source = request.source();

        target.setName(source.name());
        target.setTaxIdentificationNumber(source.taxIdentificationNumber());
        target.setTaxIdentificationType(source.taxIdentificationType());
        target.setTaxRegime(source.taxRegime());
        target.setAnnualRevenue(source.annualRevenue());
        target.setCountry(source.country());
        target.setAddress(source.address());
        target.setPostalCode(source.postalCode());
        target.setBusinessSector(source.businessSector());
        target.setEstablishmentDate(source.establishmentDate());
        target.setNotes(source.notes());
        target.setCurrencyId(source.currencyId());
        return target;
    }

}
