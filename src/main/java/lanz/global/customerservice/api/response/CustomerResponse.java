package lanz.global.customerservice.api.response;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse(UUID customerId,
                               String name,
                               String taxIdentificationNumber,
                               String taxIdentificationType,
                               String taxRegime,
                               Double annualRevenue,
                               String country,
                               String address,
                               String postalCode,
                               String businessSector,
                               LocalDate establishmentDate,
                               String notes,
                               UUID currencyId) {
}
