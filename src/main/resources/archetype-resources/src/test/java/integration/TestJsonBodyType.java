package ${package}.integration;

@SuppressWarnings("unused")
public class TestJsonBodyType {
    public String name;
    public String job;

    @Override
    public String toString() {
        return "name: " + name + ", job: " + job;
    }
}
