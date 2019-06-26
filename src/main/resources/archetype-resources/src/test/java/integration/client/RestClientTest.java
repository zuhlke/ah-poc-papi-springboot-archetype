package ${package}.integration.client;

import ${package}.api.RestClient;
import org.junit.After;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestClientTest {
    private final int port = 9090;
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
    public void blockingGetReturnsTheCorrectJson() throws IOException {
        String name = "anna";
        String job = "project manager";
        startStubHttpServer(name, job);

        TestJsonBodyType json = restClient.blockingGet("http://localhost:" + port, TestJsonBodyType.class);

        assertThat(json.name, equalTo(name));
        assertThat(json.job, equalTo(job));
    }

    @Test
    public void reactiveGetReturnsTheCorrectJson() throws IOException {
        String name = "vlad";
        String job = "developer";
        startStubHttpServer(name, job);

        TestJsonBodyType json = restClient.reactiveGet("http://localhost:" + port, TestJsonBodyType.class).block();

        assertThat(json, notNullValue());
        assertThat(json.name, equalTo(name));
        assertThat(json.job, equalTo(job));
    }

    private void startStubHttpServer(String name, String job) throws IOException {
        stubHttpServer = new StubHttpServer(port);
        stubHttpServer.setResponse("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}");
        stubHttpServer.start();
    }
}
