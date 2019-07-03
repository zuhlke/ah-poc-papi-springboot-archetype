package ${package}.unit;

import ${package}.api.RequestHandler;
import ${package}.api.HttpRestClient;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

import java.io.IOException;

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
    public void postSomeDataReturnsStatusCode200() throws IOException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setContent("hello".getBytes());
        RequestHandler requestHandler = new RequestHandler(httpRestClient);

        assertThat(requestHandler.postSomeData(mockHttpServletRequest).getStatusCodeValue(), equalTo(200));
    }

    @Test
    public void postSomeDataEchosTheSentData() throws IOException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setContent("hello".getBytes());
        RequestHandler requestHandler = new RequestHandler(httpRestClient);

        assertThat(requestHandler.postSomeData(mockHttpServletRequest).getBody(), equalTo("I've posted some data: hello!"));
    }
}