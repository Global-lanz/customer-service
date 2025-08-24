package lanz.global.customerservice.api;

import jakarta.annotation.security.RolesAllowed;
import lanz.global.customerservice.api.config.Rules;
import lanz.global.customerservice.api.request.customer.CustomerRequest;
import lanz.global.customerservice.api.request.customer.GetCustomerParams;
import lanz.global.customerservice.api.response.CustomerResponse;
import lanz.global.customerservice.api.response.FindCustomersResponse;
import lanz.global.customerservice.model.Customer;
import lanz.global.customerservice.service.CustomerService;
import lanz.global.customerservice.util.converter.ServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;
    private final ServiceConverter serviceConverter;

    @PostMapping
    @RolesAllowed(Rules.CREATE_CUSTOMER)
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer createdCustomer = customerService.createCustomer(customerRequest);

        return ResponseEntity.ok(serviceConverter.convert(createdCustomer, CustomerResponse.class));
    }

    @GetMapping
    @RolesAllowed(Rules.LIST_CUSTOMERS)
    public ResponseEntity<FindCustomersResponse> getCustomersFromCompany() {
        List<Customer> customers = customerService.getCustomersFromCompany();

        FindCustomersResponse response = new FindCustomersResponse();
        response.customers = serviceConverter.convertList(customers, CustomerResponse.class);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    @RolesAllowed(Rules.LIST_CUSTOMERS)
    public ResponseEntity<Page<CustomerResponse>> filterCustomers(@ModelAttribute GetCustomerParams params) {
        Page<Customer> page = customerService.filterCustomers(params);

        return ResponseEntity.ok(page.map(contract -> serviceConverter.convert(contract, CustomerResponse.class)));
    }

    @GetMapping("/{customerId}")
    @RolesAllowed({Rules.GET_CUSTOMER, Rules.M2M})
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable UUID customerId) {
        Customer customer = customerService.findCustomerById(customerId);

        return ResponseEntity.ok(serviceConverter.convert(customer, CustomerResponse.class));
    }

    @PutMapping("/{customerId}")
    @RolesAllowed(Rules.UPDATE_CUSTOMER)
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerService.updateCustomer(customerId, customerRequest);
        return ResponseEntity.ok(serviceConverter.convert(customer, CustomerResponse.class));
    }

    @DeleteMapping("/{customerId}")
    @RolesAllowed(Rules.DELETE_CUSTOMER)
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
