package ${package}.integration.client;

/*
    This class contains the format of the json used in the HttpRestClientTest which is
    returned by the StubHttpServer.
 */
@SuppressWarnings("unused")
public class TestJsonBodyType {
    public String name;
    public String job;

    @Override
    public String toString() {
        return "name: " + name + ", job: " + job;
    }
}
