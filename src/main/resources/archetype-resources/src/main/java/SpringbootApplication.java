package $package;

import ${package}.api.RequestHandler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

/**
 * This class contains the Spring entry point of the API. The static methods `start` and `stop`
 * can be used to easily control the program's top-level functionality, for example, in
 * integration tests.
 * <br/>
 * All the dependencies required to control this API's behaviour should be injectable
 * at this level.
 */
@SpringBootApplication
public class SpringbootApplication {
    public static final String LOG_ID = "${app-name}";

    // We use this field in order to be able to start and stop the Springboot application.
    private static ConfigurableApplicationContext context;

    public static void start(String[] args, RequestHandler requestHandler) {
        // Try "Command-B" with "initialise" highlighted
        HttpRequestReceiver.initialise(requestHandler);
        context = run(SpringbootApplication.class, args);
    }

    public static void stop(int exitCode) {
        exit(context, () -> exitCode);
    }
}
