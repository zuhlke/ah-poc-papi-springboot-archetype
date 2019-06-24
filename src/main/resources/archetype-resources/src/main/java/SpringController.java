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
*/
@RestController
public class SpringController {
    private static final Logger logger = LoggerFactory.getLogger(SpringController.class);

    private static RequestHandler requestHandler;

    static void initialise(RequestHandler requestHandler) {
        SpringController.requestHandler = requestHandler;
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(HttpServletRequest incomingRequest) {
        logger.info("Received GET request /get");

        return requestHandler.get(incomingRequest);
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(HttpServletRequest incomingRequest) {
        logger.info("Received POST request /post");

        return requestHandler.post(incomingRequest);
    }
}
