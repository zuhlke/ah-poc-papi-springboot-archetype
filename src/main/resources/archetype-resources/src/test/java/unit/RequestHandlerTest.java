package ${package}.unit;

import ${package}.RequestHandler;
import ${package}.SapiRestClient;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RequestHandlerTest {
    private SapiRestClient sapiRestClient = mock(SapiRestClient.class);

    @Test
    public void getReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(sapiRestClient);

        assertThat(requestHandler.get(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }

    @Test
    public void postReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(sapiRestClient);

        assertThat(requestHandler.post(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }
}