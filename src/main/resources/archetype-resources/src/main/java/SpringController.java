package $package;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    private static final Logger logger = LoggerFactory.getLogger(SpringController.class);

    private final RequestHandler requestHandler = new RequestHandler();

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        logger.info("Received GET request /get");

        return requestHandler.get();
    }

    @PostMapping("/post")
    public ResponseEntity<String> post() {
        logger.info("Received POST request /post");

        return requestHandler.post();
    }
}
