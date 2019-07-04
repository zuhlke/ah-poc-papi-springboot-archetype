package $package;

import ${package}.api.RequestHandler;
import ${package}.doc_annotation.OpenClosed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

/*
    Go to the tests for _this_ class: run, read and understand them right now, if you haven't already.

    This class contains the request mappings for the endpoints which are provided by this API.

    It should delegate immediately to its instance of RequestHandler, passing down a HttpServletRequest and
    expecting back a ResponseEntity<String>.

    // Try "Command-Shift-T" or use IntelliJ's top menu bar: Navigate -> Test
    TEST CLASS: src/test/java/<your package structure>/integration/server/HttpRequestReceiverTest.java
*/
@OpenClosed
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
    // Look at the tests for this class to see an example.
    @GetMapping("/some-data")
    public ResponseEntity<String> getSomeData(HttpServletRequest incomingRequest) {
        logger.info("Received GET request /some-data");
        // You should not be writing any code here.
        // Notice how this method _immediately_ delegates to its static instance of RequestHandler.
        return requestHandler.getSomeData(incomingRequest);
    }

    // This method handles an incoming POST request to the path /some-data.
    // - It is a POST request, because the annotation is PostMapping
    // - The path is /some-data because the value passed to the annotation is /some-data
    // Look at the tests for this class to see an example.
    @PostMapping("/some-data")
    public ResponseEntity<String> postSomeData(HttpServletRequest incomingRequest) throws IOException {
        logger.info("Received POST request /some-data");
        // You should not be writing any code here.
        // Notice how this method _immediately_ delegates to its static instance of RequestHandler.
        return requestHandler.postSomeData(incomingRequest);
    }
}
