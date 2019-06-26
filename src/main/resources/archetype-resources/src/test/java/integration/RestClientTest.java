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
        stubHttpServer = new StubHttpServer(port);
        stubHttpServer.setResponse("{\"name\": \"anna\", \"job\": \"project manager\"}");
        stubHttpServer.start();
        RestClient restClient = new RestClient(WebClient.create());

        TestJsonBodyType json = restClient.blockingGet("http://localhost:" + port, TestJsonBodyType.class);

        assertThat(json.name, equalTo("anna"));
        assertThat(json.job, equalTo("project manager"));
    }

    @Test
    public void canDoAReactiveGet() throws IOException {
        int port = 9091;
        stubHttpServer = new StubHttpServer(port);
        stubHttpServer.setResponse("{\"name\": \"vlad\", \"job\": \"developer\"}");
        stubHttpServer.start();
        RestClient restClient = new RestClient(WebClient.create());

        TestJsonBodyType json = restClient.reactiveGet("http://localhost:" + port, TestJsonBodyType.class).block();

        assertThat(json.name, equalTo("vlad"));
        assertThat(json.job, equalTo("developer"));
    }
}
