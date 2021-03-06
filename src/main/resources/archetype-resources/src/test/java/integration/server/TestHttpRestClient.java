package ${package}.integration.server;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/*
    This is a HTTP REST client which is used to create and send HTTP requests
    during integration tests against the API.
*/
public class TestHttpRestClient {
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