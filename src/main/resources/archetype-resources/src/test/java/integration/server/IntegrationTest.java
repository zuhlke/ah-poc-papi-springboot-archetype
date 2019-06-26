package ${package}.integration.server;

import ${package}.SpringbootApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    private final SpringHttpClient springHttpClient = new SpringHttpClient();
    private final String origin = "http://localhost:8080";

    @Before
    public void beforeEach() {
        SpringbootApplication.start(new String[]{});
    }

    @After
    public void afterEach() {
        SpringbootApplication.stop(0);
    }

    @Test
    public void canGet() {
        assertEquals(
                "This is a GET request!",
                springHttpClient.get(origin + "/get")
        );
    }

    @Test
    public void canPost() {
        assertEquals(
                "This is a POST request!",
                springHttpClient.post(origin + "/post")
        );
    }
}