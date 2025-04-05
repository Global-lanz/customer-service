package lanz.global.customerservice.service;

import lanz.global.customerservice.api.request.CustomerRequest;
import lanz.global.customerservice.exception.NotFoundException;
import lanz.global.customerservice.facade.AuthenticationFacade;
import lanz.global.customerservice.model.Customer;
import lanz.global.customerservice.repository.CustomerRepository;
import lanz.global.customerservice.util.converter.ServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final ServiceConverter serviceConverter;
    private final CustomerRepository customerRepository;
    private final AuthenticationFacade authenticationFacade;
    private final CompanyService companyService;

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = serviceConverter.convert(customerRequest, Customer.class);
        customer.setCompanyId(companyService.findCompanyById(authenticationFacade.getCompanyId()).companyId());

        if (customerRequest.currencyId() != null) {
            customer.setCurrencyId(companyService.findCurrencyById(customerRequest.currencyId()).currencyId());
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getCustomersFromCompany() {
        return customerRepository.findCustomerByCompanyId(authenticationFacade.getCompanyId());
    }

    public Customer updateCustomer(UUID customerId, CustomerRequest customerRequest) {
        Customer customer = findCustomerById(customerId);

        Customer updatedCustomer = serviceConverter.convert(customerRequest, customer, Customer.class);

        return customerRepository.save(updatedCustomer);
    }

    public Customer findCustomerById(UUID customerId) {
        return customerRepository.findCustomerByCustomerIdAndCompanyId(customerId, authenticationFacade.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Customer"));
    }

    public void deleteCustomer(UUID customerId) {
        Customer customer = findCustomerById(customerId);

        customerRepository.delete(customer);
    }
}
