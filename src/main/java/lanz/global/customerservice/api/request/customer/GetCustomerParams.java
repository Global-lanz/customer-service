package lanz.global.customerservice.api.request.customer;

import lanz.global.customerservice.api.request.PageRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.io.Serial;

@Getter
@Setter
public class GetCustomerParams extends PageRequest {

    @Serial
    private static final long serialVersionUID = 4291733757779603314L;

    private String name;
    private String taxIdentificationNumber;

    public GetCustomerParams(int pageNumber, int pageSize, Sort sort) {
        super(pageNumber, pageSize, sort);
    }
}
