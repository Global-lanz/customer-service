package lanz.global.customerservice.repository.specification;

import lanz.global.customerservice.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public abstract class CustomerSpecification {

    public static Specification<Customer> customerId(UUID customerId) {
        return (root, query, criteriaBuilder) -> {
            if (customerId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("customerId"), customerId);
        };
    }

    public static Specification<Customer> companyId(UUID companyId) {
        return (root, query, criteriaBuilder) -> {
            if (companyId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("companyId"), companyId);
        };
    }

}
