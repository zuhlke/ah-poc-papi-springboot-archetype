package ${package}.integration.server;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TestHttpClient {
    private final Class<String> STRING_RESPONSE_TYPE = String.class;
    private final RestTemplate restTemplate = createSpringRestTemplate();

    public String get(String requestUrl) {
        return restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                STRING_RESPONSE_TYPE
        ).getBody();
    }

    public String post(String requestUrl) {
        return restTemplate.exchange(
                requestUrl,
                HttpMethod.POST,
                new HttpEntity<>(new HttpHeaders()),
                STRING_RESPONSE_TYPE
        ).getBody();
    }

    private RestTemplate createSpringRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }
}