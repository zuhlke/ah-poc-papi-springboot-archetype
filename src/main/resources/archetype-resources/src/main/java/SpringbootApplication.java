package $package;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

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
