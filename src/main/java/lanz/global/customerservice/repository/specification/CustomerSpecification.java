package lanz.global.customerservice.repository.specification;

import lanz.global.customerservice.model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public abstract class CustomerSpecification {

    private CustomerSpecification() {
    }

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

    public static Specification<Customer> name(String name) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isBlank(name)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
            );
        };

    }

    public static Specification<Customer> taxIdentificationNumber(String taxIdentificationNumber) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isBlank(taxIdentificationNumber)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("taxIdentificationNumber")),
                    "%" + taxIdentificationNumber.toLowerCase() + "%"
            );
        };
    }

}
