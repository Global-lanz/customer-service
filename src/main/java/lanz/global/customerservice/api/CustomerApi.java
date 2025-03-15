package lanz.global.customerservice.api;

import jakarta.annotation.security.RolesAllowed;
import lanz.global.customerservice.api.config.Rules;
import lanz.global.customerservice.api.request.CustomerRequest;
import lanz.global.customerservice.api.response.CustomerResponse;
import lanz.global.customerservice.api.response.GetCustomersResponse;
import lanz.global.customerservice.service.CustomerService;
import lanz.global.customerservice.service.model.Customer;
import lanz.global.customerservice.util.ServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerApi {

    private final CustomerService customerService;
    private final ServiceConverter serviceConverter;

    @PostMapping
    @RolesAllowed(Rules.CREATE_CUSTOMER)
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer createdCustomer = customerService.createCustomer(customerRequest);

        return ResponseEntity.ok(serviceConverter.convert(createdCustomer));
    }

    @GetMapping
    @RolesAllowed(Rules.LIST_CUSTOMERS)
    public ResponseEntity<GetCustomersResponse> getCustomersFromCompany() {
        List<Customer> customers = customerService.getCustomersFromCompany();

        GetCustomersResponse response = new GetCustomersResponse();
        response.customers = serviceConverter.convertList(customers);

        return ResponseEntity.ok(response);
    }
}
