package lanz.global.customerservice.repository.impl;

import lanz.global.customerservice.api.request.customer.GetCustomerParams;
import lanz.global.customerservice.model.Customer;
import lanz.global.customerservice.repository.CustomerRepository;
import lanz.global.customerservice.repository.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerFilterRepository {

    private final CustomerRepository customerRepository;

    public Optional<Customer> findByFilter(UUID customerId, UUID companyId) {
        Specification<Customer> spec = Specification.where(CustomerSpecification.customerId(customerId))
                .and(CustomerSpecification.companyId(companyId));

        return customerRepository.findOne(spec);
    }

    public Page<Customer> findAllByFilter(UUID companyId, GetCustomerParams params) {
        Specification<Customer> spec = Specification.where(CustomerSpecification.name(params.getName()))
                .and(CustomerSpecification.taxIdentificationNumber(params.getTaxIdentificationNumber()))
                .and(CustomerSpecification.companyId(companyId));

        return customerRepository.findAll(spec, params);
    }

}
