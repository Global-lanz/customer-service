package lanz.global.customerservice.service;

import lanz.global.customerservice.api.request.customer.CustomerRequest;
import lanz.global.customerservice.api.request.customer.GetCustomerParams;
import lanz.global.customerservice.exception.BadRequestException;
import lanz.global.customerservice.exception.NotFoundException;
import lanz.global.customerservice.external.api.finance.response.CurrencyResponse;
import lanz.global.customerservice.facade.AuthenticationFacade;
import lanz.global.customerservice.model.Customer;
import lanz.global.customerservice.repository.CustomerRepository;
import lanz.global.customerservice.repository.impl.CustomerFilterRepository;
import lanz.global.customerservice.util.converter.ServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ServiceConverter serviceConverter;
    private final CustomerRepository customerRepository;
    private final CustomerFilterRepository customerFilterRepository;
    private final AuthenticationFacade authenticationFacade;
    private final CompanyService companyService;
    private final FinanceService financeService;

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = serviceConverter.convert(customerRequest, Customer.class);
        customer.setCompanyId(companyService.findCompanyById(authenticationFacade.getCompanyId()).companyId());

        CurrencyResponse currencyResponse = companyService.findCurrencyById(customerRequest.currencyId());

        if (currencyResponse != null) {
            customer.setCurrencyId(currencyResponse.currencyId());
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
        return customerFilterRepository.findByFilter(customerId, authenticationFacade.getCompanyId())
                .orElseThrow(() -> new NotFoundException("customer"));
    }

    public void deleteCustomer(UUID customerId) {
        Customer customer = findCustomerById(customerId);
        validateCustomerContainsContracts(customerId);
        customerRepository.delete(customer);
    }

    public Page<Customer> filterCustomers(GetCustomerParams params) {
        UUID companyId = authenticationFacade.getCompanyId();

        return customerFilterRepository.findAllByFilter(companyId, params);
    }

    private void validateCustomerContainsContracts(UUID customerId) {
        if (financeService.customerContainsLinkedContracts(customerId)) {
            throw new BadRequestException("exception.customer.linked-contracts-exception.title", "exception.customer.linked-contracts-exception.message");
        }
    }
}
