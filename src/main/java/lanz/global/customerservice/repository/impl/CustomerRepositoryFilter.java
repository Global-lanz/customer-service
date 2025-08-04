package lanz.global.customerservice.repository.impl;

import lanz.global.customerservice.model.Customer;
import lanz.global.customerservice.repository.CustomerRepository;
import lanz.global.customerservice.repository.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryFilter {

    private final CustomerRepository customerRepository;

    public Optional<Customer> findByFilter(UUID customerId, UUID companyId) {
        Specification<Customer> spec = Specification.where(CustomerSpecification.customerId(customerId))
                .and(CustomerSpecification.companyId(companyId));

        return customerRepository.findOne(spec);
    }

}
