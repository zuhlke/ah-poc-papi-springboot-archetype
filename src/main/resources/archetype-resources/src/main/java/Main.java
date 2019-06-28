package $package;

import ${package}.api.RequestHandler;
import ${package}.api.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

/*
    What is this class?
        This is the entry point of the program. It is called Main because the first thing
        you learn in Java is that `Main` is the entry point.
        This is one example of "The Power of Sameness".

    How does this API work?
        The Springboot framework uses the Spring framework to automatically route incoming
        HTTP requests into the application at specified points. Those points are the
        _Mappings_ defined within classes annotated with _@RestController_, in this case,
        our RestController class is called HttpRequestReceiver.
        _Mappings_ are methods which are annotated with mapping annotations, such as @GetMapping,
        @PostMapping or more generally, @RequestMapping.

    Where's the entry point to this program?
        The annotated methods in HttpRequestReceiver are the entry points. Incoming HTTP requests
        are encoded into instances of HttpServletRequest and passed into those methods as
        parameters. The return type of these methods is ResponseEntity<String>, which means
        a HTTP response with the response body given as a string. This return value is then
        encoded by the Springboot framework into a HTTP response and sent back to the
        original sender.

   Structure of this project folder
        This project has been automatically generated by the PAPI Core Product. It contains a
        number of files and folders at the top level.
        - PAPI_Core_Product_user_guide.md
          This is a markdown file with information about how to use this repository to write
          APIs effectively.
        - run-tests
          This is an executable script for running all the tests in the repository, including
          both unit and integration tests.
        - build-jar
          This is an executable script which builds a jar. The location of the jar is given in
          the output of the script.
        - start-server
          This script starts the server locally.
*/
public class Main {
    public static void main(String[] args) {
        // Try "Command-B" with "start" highlighted
        SpringbootApplication.start(args, new RequestHandler(new RestClient(WebClient.create())));
    }
}