package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ${app-name}Controller {

    private static final Logger logger = LoggerFactory.getLogger(${app-name}Controller.class);

    @GetMapping("/${resource-name}")
    public ResponseEntity<String> getResource(){
        logger.info("Received GET request to resource: \"/${resource-name}\"");

        return ResponseEntity
            .status(HttpStatus.NOT_IMPLEMENTED)
            .contentType(MediaType.APPLICATION_JSON)
            .body("{\"status\": \"Work-In-Progress: /${resource-name} response\"}");
    }

    #if( ${teapot-enabled} == "y" || ${teapot-enabled} == "yes" || ${teapot-enabled} == "true" )
    @GetMapping("/teapot")
    public ResponseEntity<String> getTeapot(){
        logger.info("Received GET request to resource: \"/teapot\"");

        return ResponseEntity
            .status(HttpStatus.I_AM_A_TEAPOT)
            .contentType(MediaType.APPLICATION_JSON)
            .body("{\"status\": \"Cuppa Tea?\"}");
    }
    #end
}
