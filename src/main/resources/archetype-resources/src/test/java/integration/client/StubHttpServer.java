package ${package}.integration.client;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/*
    This is a class which creates and serves a HTTP server for use in testing. The data it
    serves can be specified using the setResponse method.
*/
public class StubHttpServer extends NanoHTTPD {
    private String response = "{\"message\": \"response is unset\"}";

    public StubHttpServer(int port) {
        super(port);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public void start() throws IOException {
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, true);
    }

    @Override
    public Response serve(IHTTPSession session) {
        return newFixedLengthResponse(Response.Status.OK, "application/json", response);
    }
}
