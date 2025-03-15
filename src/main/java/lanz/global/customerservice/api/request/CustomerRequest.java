package lanz.global.customerservice.api.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerRequest(@NotBlank String name,
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
