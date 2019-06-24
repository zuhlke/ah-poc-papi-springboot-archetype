package $package;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

/*
    This class contains the Spring entry point of the API. By providing the static
    methods `start` and `stop`, the program's top-level functionality can be controlled
    easily within integration tests.
*/
@SpringBootApplication
public class SpringbootApplication {
    public static final String LOG_ID = "log_id";
    private static ConfigurableApplicationContext context;

    public static void start(String[] args) {
        context = run(SpringbootApplication.class, args);
    }

    public static void stop(int exitCode) {
        exit(context, () -> exitCode);
    }
}
