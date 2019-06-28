package ${package}.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/*
    This class provides an annotation-free interface for responding to REST calls. It is immediately
    delegated to by the HttpRequestReceiver in the top level to handle incoming requests.

    The requests are given as instances of HttpServletRequest, which contains methods for accessing
    all the features of a HTTP request, such as the request url, the request headers and the request body.

    The responses should be returned as instances of ResponseEntity<String>, which can be constructed
    to include any response status, response headers and response body that you'd like.

    There should be no spring dependency-injection framework-ery in this package. That has been quarantined
    at the top level for reasons described in the comment over the SpringbootApplication class.

    // Try using the top bar: Navigate -> Test
    TEST CLASS: src/test/java/<your package structure>/unit/RequestHandlerTest.java
*/
public class RequestHandler {
    private final RestClient restClient;

    public RequestHandler(RestClient restClient) {
        this.restClient = restClient;
    }

    public ResponseEntity<String> get(HttpServletRequest incomingRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("This is a GET request!");
    }

    public ResponseEntity<String> post(HttpServletRequest incomingRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("This is a POST request!");
    }
}