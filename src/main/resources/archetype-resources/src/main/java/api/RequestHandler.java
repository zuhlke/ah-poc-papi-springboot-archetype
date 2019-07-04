package ${package}.api;

import ${package}.doc_annotation.OpenClosed;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * This class provides an interface for responding to REST calls. It is immediately
 * delegated to by the HttpRequestReceiver in the top level to handle incoming requests.
 * <br/>
 * The requests are given as instances of HttpServletRequest, which contains methods for accessing
 * all the features of a HTTP request, such as the request url, the request headers and the request body.
 * <br/>
 * The responses should be returned as instances of ResponseEntity<String>, which can be constructed
 * to include any response status, response headers and response body that you'd like.
 * <br/>
 * There should be no spring dependency-injection framework-ery in this package. That has been quarantined
 * at the top level to improve testability and usability.
 */
@OpenClosed
public class RequestHandler {
    private final HttpRestClient httpRestClient;

    public RequestHandler(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    public ResponseEntity<String> getSomeData(HttpServletRequest incomingRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("I've got some data!");
    }

    public ResponseEntity<String> postSomeData(HttpServletRequest incomingRequest) throws IOException {
        String requestBody = extractRequestBody(incomingRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("I've posted some data: " + requestBody + "!");
    }

    private String extractRequestBody(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }
}