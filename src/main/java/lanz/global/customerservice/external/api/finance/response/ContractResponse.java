package lanz.global.customerservice.external.api.finance.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ContractResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 7142606946855707319L;

    private UUID contractId;

    private BigDecimal totalAmount;
    private String frequency;
    private Integer paymentDay;
    private LocalDate start;
    private LocalDate end;
    private String terminationClause;
    private BigDecimal penaltyFee;
    private String description;
    private ContractCustomerResponse customer;
    private UUID currencyId;
}
