package ${package}.integration;

import ${package}.api.RestClient;
import org.junit.After;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestClientTest {
    private StubHttpServer stubHttpServer;
    private final RestClient restClient = new RestClient(WebClient.create());

    @After
    public void tearDown() {
        if (stubHttpServer != null) {
            stubHttpServer.stop();
            stubHttpServer = null;
        }
    }

    @Test
    public void canDoABlockingGet() throws IOException {
        int port = 9090;
        String name = "anna";
        String job = "project manager";
        startStubHttpServer(port, name, job);

        TestJsonBodyType json = restClient.blockingGet("http://localhost:" + port, TestJsonBodyType.class);

        assertThat(json.name, equalTo(name));
        assertThat(json.job, equalTo(job));
    }

    @Test
    public void canDoAReactiveGet() throws IOException {
        int port = 9091;
        String name = "vlad";
        String job = "developer";
        startStubHttpServer(port, name, job);

        TestJsonBodyType json = restClient.reactiveGet("http://localhost:" + port, TestJsonBodyType.class).block();

        assertThat(json.name, equalTo(name));
        assertThat(json.job, equalTo(job));
    }

    private void startStubHttpServer(int port, String name, String job) throws IOException {
        stubHttpServer = new StubHttpServer(port);
        stubHttpServer.setResponse("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}");
        stubHttpServer.start();
    }
}
