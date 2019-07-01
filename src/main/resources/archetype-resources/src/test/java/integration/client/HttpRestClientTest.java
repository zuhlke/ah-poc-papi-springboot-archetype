package ${package}.integration.client;

import ${package}.api.HttpRestClient;

import org.junit.After;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/*
    This is an integration test against the HttpRestClient.

    It verifies that the HttpRestClient can successfully make HTTP requests to a server.

    For example, in the test "blockingGetReturnsTheCorrectJson", a stub server is created
    and started for the test, and it is verified that the httpRestClient can make a get
    request to it and parse the correct json response body.
*/
public class HttpRestClientTest {
    private final int port = 9090;
    private final HttpRestClient httpRestClient = new HttpRestClient(WebClient.create());
    private StubHttpServer stubHttpServer;

    @After
    public void afterEach() {
        if (stubHttpServer != null) {
            stubHttpServer.stop();
            stubHttpServer = null;
        }
    }

    /*
        This test verifies that the HttpRestClient can be used to make a HTTP GET request and parse the
        response body from json into an instance of a supplied class.

        A stub http server is started in this test, using the method 'startStubHttpServer'. This server
        returns some json in the response body.

        To pass the test then, the HttpRestClient must correctly make the request and parse the response
        json into an instance of the supplied class. It uses the blocking implementation of the
        HttpRestClient's HTTP GET functionality. There is more on this in the class itself.
    */
    @Test
    public void blockingGetReturnsTheCorrectJson() throws IOException {
        String name = "anna";
        String job = "project manager";
        startStubHttpServer(name, job);

        TestJsonBodyType json = httpRestClient.blockingGet("http://localhost:" + port, TestJsonBodyType.class);

        assertThat(json.name, equalTo(name));
        assertThat(json.job, equalTo(job));
    }

    /*
        This test is the same as the above test, but it uses the non-blocking implementation of the
        HttpRestClient's HTTP GET functionality. There is more on this in the class itself.
    */
    @Test
    public void reactiveGetReturnsTheCorrectJson() throws IOException {
        String name = "vlad";
        String job = "developer";
        startStubHttpServer(name, job);

        TestJsonBodyType json = httpRestClient.reactiveGet("http://localhost:" + port, TestJsonBodyType.class).block();

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
