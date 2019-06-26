package $package;

import ${package}.api.RequestHandler;
import ${package}.api.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

/*
    This is the entry point of the program. It is called Main because the first thing
    you learn in Java is that `Main` is the entry point.
    This is one example of "The Power of Sameness".
*/
public class Main {
    public static void main(String[] args) {
        SpringbootApplication.start(args, new RequestHandler(new RestClient(WebClient.create())));
    }
}