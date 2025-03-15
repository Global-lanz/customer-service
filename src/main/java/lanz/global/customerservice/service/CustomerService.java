package lanz.global.customerservice.service;

import lanz.global.customerservice.api.request.CustomerRequest;
import lanz.global.customerservice.facade.AuthenticationFacade;
import lanz.global.customerservice.repository.CompanyRepository;
import lanz.global.customerservice.repository.CurrencyRepository;
import lanz.global.customerservice.repository.CustomerRepository;
import lanz.global.customerservice.service.model.Customer;
import lanz.global.customerservice.util.ServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final ServiceConverter serviceConverter;
    private final CompanyRepository companyRepository;
    private final CurrencyRepository currencyRepository;
    private final CustomerRepository customerRepository;
    private final AuthenticationFacade authenticationFacade;

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = serviceConverter.convert(customerRequest);
        customer.setCompany(companyRepository.getReferenceById(authenticationFacade.getCompanyId()));

        if (customerRequest.currencyId() != null) {
            customer.setCurrency(currencyRepository.findById(customerRequest.currencyId()).orElse(null));
        }

        return customerRepository.save(customer);
    }
}
