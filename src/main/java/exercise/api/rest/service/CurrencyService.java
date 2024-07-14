package exercise.api.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.model.CurrencyDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyService {

    @Value("${wiremock.base-url}")
    private String wireMockBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @SneakyThrows
    public List<CurrencyDto> getCurrencies() {
        String url = wireMockBaseUrl + "/v1/currencies";
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, new TypeReference<List<CurrencyDto>>() {});
    }

    @SneakyThrows
    public CurrencyDto getCurrencyByCode(String currencyCode){
        String url = wireMockBaseUrl + "/v1/currencies/" + currencyCode;
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, CurrencyDto.class);
    }
}

