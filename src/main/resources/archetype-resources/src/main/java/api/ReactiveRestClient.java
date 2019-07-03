package ${package}.api;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/*
    Go to the tests: run, read and understand them right now, if you haven't already.

    This class contains the implementation of the reactive rest client, which uses the Spring WebFlux library's
    WebClient class to make non-blocking HTTP requests. It is used by the HttpRestClient to make HTTP calls.
*/
public class ReactiveRestClient {
    private final WebClient webClient;

    public ReactiveRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> executeReactiveRequest(String url, HttpMethod method, String requestBody, Class<T> responseBodyType) {
        return createReactiveJsonRequest(url, method)
                .body(BodyInserters.fromObject(requestBody))
                .retrieve()
                .onStatus(HttpStatus::isError, errorStatusResponseFunction(url, method.name()))
                .bodyToMono(responseBodyType);
    }

    public <T> Mono<T> executeReactiveRequest(String url, HttpMethod method, Class<T> responseBodyType) {
        return executeReactiveRequest(url, method, "", responseBodyType);
    }

    private Function<ClientResponse, Mono<? extends Throwable>> errorStatusResponseFunction(String url, String method) {
        return response -> Mono.error(new Exception("Request '" + method + " " + url + "' gave response with status code" + response.statusCode().value()));
    }

    private WebClient.RequestBodySpec createReactiveJsonRequest(String url, HttpMethod method) {
        return webClient.method(method)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }
}
