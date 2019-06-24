package $package;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/*
    This class provides an annotation-independent interface for responding to REST calls.
*/
public class RequestHandler {
    private final SapiRestClient sapiRestClient;

    public RequestHandler(SapiRestClient sapiRestClient) {
        this.sapiRestClient = sapiRestClient;
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