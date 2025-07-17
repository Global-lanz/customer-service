package lanz.global.customerservice.external.api.finance.request;

import lanz.global.customerservice.api.request.PageRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.io.Serial;
import java.util.UUID;

@Getter
@Setter
public class GetContractParams extends PageRequest {

    @Serial
    private static final long serialVersionUID = 1488794646356144999L;

    private UUID customerId;

    public GetContractParams() {
        super(0, 10, Sort.unsorted());
    }

    public GetContractParams(UUID customerId) {
        super(0, 10, Sort.unsorted());
        this.customerId = customerId;
    }
}