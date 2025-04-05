package lanz.global.customerservice.repository;

import lanz.global.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findCustomerByCompanyId(UUID companyId);

    Optional<Customer> findCustomerByCustomerIdAndCompanyId(UUID customerId, UUID companyId);

}
