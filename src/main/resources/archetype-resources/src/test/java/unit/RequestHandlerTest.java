package ${package}.unit;

import ${package}.RequestHandler;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RequestHandlerTest {
    @Test
    public void getReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler();

        assertThat(requestHandler.get(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }

    @Test
    public void postReturnsStatusCode200() {
        RequestHandler requestHandler = new RequestHandler();

        assertThat(requestHandler.post(new MockHttpServletRequest()).getStatusCodeValue(), equalTo(200));
    }
}