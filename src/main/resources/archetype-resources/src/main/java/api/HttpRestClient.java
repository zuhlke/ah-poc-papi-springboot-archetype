package ${package}.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
    This class contains a REST client which can be used to make HTTP requests, both
    blocking ones and non-blocking (reactive) ones. You need to define the type of the
    response body you're expecting.
    There is an example in the integration tests for this class. You can navigate to the
    tests for this class by using the top menu bar in the IntelliJ IDE : Navigate -> Test.

    // Try "Command-Shift-T" or use IntelliJ's top menu bar: Navigate -> Test
    TEST CLASS: src/test/java/<your package structure>/integration/client/HttpRestClientTest.java
*/
public class HttpRestClient {
    private final WebClient webClient;

    public HttpRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> get(String url, Class<T> bodyType) {
        return reactiveGet(url, bodyType);
    }

    public <T> Mono<T> post(String url, Class<T> bodyType) {
        return reactivePost(url, bodyType);
    }

    /*
        Reactive

        This means that this HTTP call will be _non blocking_. This means that it runs
        asynchronously - it will not block the thread that it runs in. This enables better performance.
    */
    public <T> Mono<T> reactiveGet(String url, Class<T> bodyType) {
        return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.error(new Exception("Request 'GET " + url + "' gave response with status code" + response.statusCode().value())))
                .bodyToMono(bodyType);
    }

    /*
        Blocking

        This means that this HTTP call will be _blocking_. This means that it runs
        synchronously - it will block the thread that it runs in. Synchronous behaviour
        is easier to reason about.
    */
    public <T> T blockingGet(String url, Class<T> bodyType) {
        return reactiveGet(url, bodyType).block();
    }

    public <T> Mono<T> reactivePost(String url, Class<T> bodyType) {
        return webClient.post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.error(new Exception("Request 'GET " + url + "' gave response with status code" + response.statusCode().value())))
                .bodyToMono(bodyType);
    }

    public <T> T blockingPost(String url, Class<T> bodyType) {
        return reactivePost(url, bodyType).block();
    }
}