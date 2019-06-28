package $package;

import ${package}.api.RequestHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*
    This class contains the request mappings for the endpoints which are provided by this API.

    It should delegate immediately to its instance of RequestHandler, passing down a HttpServletRequest and
    expecting back a ResponseEntity<String>.

    TEST CLASS: src/test/java/<your package structure>/integration/server/IntegrationTest.java
*/
@RestController
public class HttpRequestReceiver {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestReceiver.class);

    private static RequestHandler requestHandler;

    static void initialise(RequestHandler requestHandler) {
        HttpRequestReceiver.requestHandler = requestHandler;
    }

    // This method handles an incoming GET request to the path /some-data.
    // - It is a GET request, because the annotation is GetMapping
    // - The path is /some-data because the value passed to the annotation is /some-data
    @GetMapping("/some-data")
    public ResponseEntity<String> get(HttpServletRequest incomingRequest) {
        logger.info("Received GET request /some-data");

        // Note that this method logs the request and then immediately delegates to the requestHandler.
        return requestHandler.get(incomingRequest);
    }

    @PostMapping("/some-data")
    public ResponseEntity<String> post(HttpServletRequest incomingRequest) {
        logger.info("Received POST request /some-data");

        return requestHandler.post(incomingRequest);
    }
}
