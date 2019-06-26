package ${package}.integration;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

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
