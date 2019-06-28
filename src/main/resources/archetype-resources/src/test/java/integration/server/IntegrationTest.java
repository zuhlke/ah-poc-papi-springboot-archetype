package ${package}.integration.server;

import ${package}.SpringbootApplication;
import ${package}.api.RequestHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    private final String origin = "http://localhost:8080";

    private final SpringHttpClient springHttpClient = new SpringHttpClient();

    private final RequestHandler stubRequestHandler = mock(RequestHandler.class);

    @Before
    public void beforeEach() {
        SpringbootApplication.start(new String[]{}, stubRequestHandler);
    }

    @After
    public void afterEach() {
        SpringbootApplication.stop(0);
    }

    @Test
    public void getEndpointRespondsToGetRequests() {
        when(stubRequestHandler.get(any())).thenReturn(okResponseWithJsonBody("! GET !"));

        assertEquals(
                "! GET !",
                springHttpClient.get(origin + "/some-data")
        );
    }

    @Test
    public void postEndpointRespondsToPostRequests() {
        when(stubRequestHandler.post(any())).thenReturn(okResponseWithJsonBody("! POST !"));

        assertEquals(
                "! POST !",
                springHttpClient.post(origin + "/some-data")
        );
    }

    private ResponseEntity<String> okResponseWithJsonBody(String body) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(body);
    }
}