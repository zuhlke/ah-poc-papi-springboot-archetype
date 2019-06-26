package ${package}.unit;

import ${package}.api.RequestHandler;
import ${package}.api.RestClient;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RequestHandlerTest {
    private final RestClient restClient = mock(RestClient.class);

    @Test
    public void getReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(restClient);

        assertThat(requestHandler.get(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }

    @Test
    public void postReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(restClient);

        assertThat(requestHandler.post(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }
}