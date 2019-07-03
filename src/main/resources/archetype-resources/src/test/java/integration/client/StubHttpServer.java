package ${package}.integration.client;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/*
    This is a class which creates and serves a HTTP server for use in testing. The data it
    serves can be specified using the setResponse method.
*/
public class StubHttpServer extends NanoHTTPD {
    private String response = "{\"message\": \"response is unset\"}";
    private String lastSentRequestBody = null;

    public StubHttpServer(int port) {
        super(port);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String lastSentRequestBody() {
        return lastSentRequestBody;
    }

    @Override
    public void start() throws IOException {
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, true);
    }

    @Override
    public Response serve(IHTTPSession session) {
        try {
            lastSentRequestBody = extractRequestBody(session);
        } catch (Exception ignored) {
            // If there is no request body, it will fail, but who cares.
        }

        return newFixedLengthResponse(Response.Status.OK, "application/json", response);
    }

    private String extractRequestBody(IHTTPSession session) throws IOException {
        int contentLength = Integer.parseInt(session.getHeaders().get("content-length"));
        byte[] buffer = new byte[contentLength];
        int bytesRead = session.getInputStream().read(buffer, 0, contentLength);
        return new String(buffer, 0, bytesRead);
    }
}
