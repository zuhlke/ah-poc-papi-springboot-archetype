package ${package}.api;

import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

/*
    This class contains a REST client which can be used to make HTTP requests, both
    blocking ones and non-blocking (reactive) ones. You need to define the type of the
    response body you're expecting as a class whose public fields are the json keys
    you're expecting to receive from the server.
    There is an example in the integration tests for this class. You can navigate to the
    tests for this class by using the top menu bar in the IntelliJ IDE : Navigate -> Test.

    // Try "Command-Shift-T" or use IntelliJ's top menu bar: Navigate -> Test
    TEST CLASS: src/test/java/<your package structure>/integration/client/HttpRestClientTest.java
*/
public class HttpRestClient {
    private final ReactiveRestClient reactiveRestClient;

    public HttpRestClient(ReactiveRestClient reactiveRestClient) {
        this.reactiveRestClient = reactiveRestClient;
    }

    public <T> Mono<T> get(String url, Class<T> bodyType) {
        return reactiveGet(url, bodyType);
    }

    public <T> Mono<T> get(String url, String requestBody, Class<T> responseBodyType) {
        return reactiveGet(url, requestBody, responseBodyType);
    }

    public <T> Mono<T> post(String url, Class<T> bodyType) {
        return reactivePost(url, bodyType);
    }

    public <T> Mono<T> post(String url, String requestBody, Class<T> responseBodyType) {
        return reactivePost(url, requestBody, responseBodyType);
    }

    /*
        Reactive

        This means that this HTTP call will be _non blocking_. This means that it runs
        asynchronously - it will not block the thread that it runs in. This enables better performance.
    */
    public <T> Mono<T> reactiveGet(String url, Class<T> responseBodyType) {
        return reactiveRestClient.executeReactiveRequest(url, HttpMethod.GET, responseBodyType);
    }

    public <T> Mono<T> reactiveGet(String url, String requestBody, Class<T> responseBodyType) {
        return reactiveRestClient.executeReactiveRequest(url, HttpMethod.GET, requestBody, responseBodyType);
    }

    public <T> Mono<T> reactivePost(String url, Class<T> responseBodyType) {
        return reactiveRestClient.executeReactiveRequest(url, HttpMethod.POST, responseBodyType);
    }

    public <T> Mono<T> reactivePost(String url, String requestBody, Class<T> responseBodyType) {
        return reactiveRestClient.executeReactiveRequest(url, HttpMethod.POST, requestBody, responseBodyType);
    }

    /*
        Blocking

        This means that this HTTP call will be _blocking_. This means that it runs
        synchronously - it will block the thread that it runs in. Synchronous behaviour
        is easier to reason about, but has worse performance.
    */
    public <T> T blockingGet(String url, Class<T> responseBodyType) {
        return reactiveGet(url, responseBodyType).block();
    }

    public <T> T blockingGet(String url, String requestBody, Class<T> responseBodyType) {
        return reactiveGet(url, requestBody, responseBodyType).block();
    }

    public <T> T blockingPost(String url, Class<T> responseBodyType) {
        return reactivePost(url, responseBodyType).block();
    }

    public <T> T blockingPost(String url, String requestBody, Class<T> responseBodyType) {
        return reactivePost(url, requestBody, responseBodyType).block();
    }
}