package co.com.literalura.service.implementation;

import co.com.literalura.service.IConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvertData implements IConvertData {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getApiData(String json, Class<T> model) {
        try {
            return objectMapper.readValue(json, model);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
