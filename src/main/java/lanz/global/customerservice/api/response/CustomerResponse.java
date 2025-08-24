package lanz.global.customerservice.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse(@Schema(description = "The ID of the customer") UUID customerId,
                               @Schema(description = "The name of the customer") String name,
                               @Schema(description = "The tax identification number of the customer") String taxIdentificationNumber,
                               @Schema(description = "The tax identification type of the customer") String taxIdentificationType,
                               @Schema(description = "The tax regime of the customer") String taxRegime,
                               @Schema(description = "The annual revenue of the customer") Double annualRevenue,
                               @Schema(description = "The country of the customer") String country,
                               @Schema(description = "The address of the customer") String address,
                               @Schema(description = "The postal code of the customer") String postalCode,
                               @Schema(description = "The business sector of the customer") String businessSector,
                               @Schema(description = "The establishment date of the customer") LocalDate establishmentDate,
                               @Schema(description = "The notes") String notes,
                               @Schema(description = "The base currency of the customer") UUID currencyId) {
}
