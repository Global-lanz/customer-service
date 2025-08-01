package lanz.global.customerservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lanz.global.customerservice.exception.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder {

    private final ObjectMapper objectMapper;

    public ErrorResponse decode(FeignException exception) {
        return exception.responseBody()
                .map(buffer -> {
                    try {
                        return objectMapper.readValue(toByteArray(buffer), ErrorResponse.class);
                    } catch (Exception e) {
                        // Log se quiser
                        return null;
                    }
                })
                .orElse(null);
    }

    private byte[] toByteArray(ByteBuffer buffer) {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return bytes;
    }

}
