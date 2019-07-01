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

/*
    This class is an integration test against the server.

    It verifies that the HttpRequestReceiver succesfully receives requests to the expected endpoints and that it
    delegates the creation of its response body to the RequestHandler by calling the appropriate method defined
    on the RequestHandler.

    For example, the test "someDataEndpointRespondsToGetRequests" verifies that the /some-data endpoint responds to GET
    requests, and the response body for the HTTP response is created by the method called "getSomeData" defined on
    the RequestHandler class.
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpRequestReceiverTest {
    private final String origin = "http://localhost:8080";

    private final TestHttpRestClient testHttpRestClient = new TestHttpRestClient();

    private final RequestHandler stubRequestHandler = mock(RequestHandler.class);

    @Before
    public void beforeEach() {
        SpringbootApplication.start(new String[]{}, stubRequestHandler);
    }

    @After
    public void afterEach() {
        SpringbootApplication.stop(0);
    }

    /*
        This test verifies that for the GET endpoint, /some-data, the response body returned by
        the server is the same as the response body returned by the RequestHandler injected into
        the server at startup time.

        In this test, there is a stub implementation of the RequestHandler object.
        Its 'getSomeData()' method is stubbed to always return a HTTP response with status
        code 200 (OK) and the response body "stubbed GET response data".

        We use the TestHttpRestClient instance to make a HTTP GET request to the server at the
        endpoint /some-data. We verify that the response body is equal to the response body returned
        by the stub.
    */
    @Test
    public void someDataEndpointRespondsToGetRequests() {
        when(stubRequestHandler.getSomeData(any())).thenReturn(okResponseWithJsonBody("stubbed GET response data"));

        assertEquals(
                "stubbed GET response data",
                testHttpRestClient.get(origin + "/some-data")
        );
    }

    /*
        This test verifies that for the POST endpoint, /some-data, the response body returned by
        the server is the same as the response body returned by the RequestHandler injected into
        the server at startup time.

        In this test, there is a stub implementation of the RequestHandler object.
        Its 'postSomeData()' method is stubbed to always return a HTTP response with status
        code 200 (OK) and the response body "stubbed POST response data".

        We use the TestHttpRestClient instance to make a HTTP POST request to the server at the
        endpoint /some-data. We verify that the response body is equal to the response body returned
        by the stub.
    */
    @Test
    public void someDataEndpointRespondsToPostRequests() {
        when(stubRequestHandler.postSomeData(any())).thenReturn(okResponseWithJsonBody("stubbed POST response data"));

        assertEquals(
                "stubbed POST response data",
                testHttpRestClient.post(origin + "/some-data")
        );
    }

    private ResponseEntity<String> okResponseWithJsonBody(String body) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(body);
    }
}