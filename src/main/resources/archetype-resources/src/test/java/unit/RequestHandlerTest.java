package ${package}.unit;

import ${package}.api.RequestHandler;
import ${package}.api.HttpRestClient;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

/*
    This is a unit test against the RequestHandler. It mocks the dependencies of the
    RequestHandler using Mockito. It's job is to verify that instances of the
    RequestHandler class behave correctly, for example, that the getSomeData(...)
    method returns a HTTP response which status code 200.
*/
public class RequestHandlerTest {
    private final HttpRestClient httpRestClient = mock(HttpRestClient.class);

    @Test
    public void getSomeDataReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(httpRestClient);

        assertThat(requestHandler.getSomeData(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }

    @Test
    public void postSomeDataReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler(httpRestClient);

        assertThat(requestHandler.postSomeData(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }
}