package $package;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    private static final Logger logger = LoggerFactory.getLogger(SpringController.class);

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        logger.info("Received GET request /get");

        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"status\": \"Work-In-Progress: /get response\"}");
    }

    @PostMapping("/post")
    public ResponseEntity<String> post() {
        logger.info("Received POST request /post");

        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"status\": \"Cuppa Tea?\"}");
    }
}
