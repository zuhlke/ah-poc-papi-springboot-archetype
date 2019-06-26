package ${package}.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
    This class contains our implementation of a REST interface with backend systems.

    The implementation should conform to a high standard of the non-functional
    requirements around performance, security and reliability.
*/
public class RestClient {
    private final WebClient webClient;

    public RestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> reactiveGet(String url, Class<T> bodyType) {
        return webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.error(new Exception("Request 'GET " + url + "' gave response with status code" + response.statusCode().value())))
                .bodyToMono(bodyType);
    }

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