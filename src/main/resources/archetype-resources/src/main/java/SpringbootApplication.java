package $package;

import ${package}.api.RequestHandler;
import ${package}.api.RestClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.boot.SpringApplication.*;

/*
    This class contains the Spring entry point of the API. By providing the static
    methods `start` and `stop`, the program's top-level functionality can be controlled
    easily within integration tests.
    All the dependencies required to run this spring application can be injected at this level,
    meaning that the whole system can be exercised with any component being stubbed or mocked. The
    effect is that this API is extremely easy to write automated tests for and reason about, which
    greatly decreases the cost of change.
*/
@SpringBootApplication
public class SpringbootApplication {
    public static final String LOG_ID = "${app-name}";
    private static ConfigurableApplicationContext context;

    public static void start(String[] args) {
        SpringController.initialise(new RequestHandler(new RestClient(WebClient.create())));
        context = run(SpringbootApplication.class, args);
    }

    public static void stop(int exitCode) {
        exit(context, () -> exitCode);
    }
}
