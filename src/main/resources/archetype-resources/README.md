#set( $H = '#' ) ## Set the variable H to '#', so we can make a '#' with $H
$H PAPI Core Product

$H What is this?

- The PAPI Core Product is a set of resources for helping you to build a Springboot HTTP REST API.

- The generated code is all yours and you should own it as such.

- The code has been designed specifically for _extensibility_ and _flexibility_, so that it is as easy
  as possible for you to add new functionality without modifying lots of existing code, but instead by
  extending the codebase with new classes to support the needs of your API.
  
$H What should I do?

- You should read this document. Of course, this template is designed to account for the eventuality
  that you just skim read it. That's fine. Very much not recommended, but fine.
  
- You should go run the tests! Now! Right now! At this very moment!

- You should look at the files in this repository and make yourself feel at home in it.

- You should run `git init` and add and commit everything that appears. An appropriate `.gitignore`
  has been generated.

- After you have run the tests, you should read them and make yourself happy with the tiny amount of
  behaviour that is provided to you by this template.

$H What is the most effective way for me to use this?

- **A fairly small amount of knowledge will take a very, very long way:**
  - Understand the basics of HTTP and how computers use it to communicate over a network.
  - Understand how the Java object oriented programming language works and the associated jargon. Can you
    explain to yourself, in your own words, the difference between a class and an instance? How about a
    function versus a method? A variable versus a field? How are instance methods and fields different to
    static methods and fields? Can you explain to yourself, in your own words, what is referred to by the
    phrase "message-passing polymorphism"?
  - Be familiar and comfortable with using your IDE to efficiently navigate code, run tests and perform
    automated refactorings such as extract variable and extract method.
  - Understand the basics of the entry point to a Springboot application, regarding the RestController and
    the RequestMappings

Beyond the basic knowledge above, you should be fine. Even so, I will below lay out some details about
this template which you will find useful.

#### Packaging

There is the top level and the api package. In the top level is the entry point, which starts the server
and injects whatever dependencies are necessary at run-time, under your explicit control. In the api
package is the RequestHandler and it's dependencies, which collaborate to produce HTTP responses to
HTTP requests - this is the essential technical functionality of a REST API.

#### Classes

- The HttpRequestReceiver is the epidermis (google it) of the API, where HTTP requests go in and HTTP
  responses come out. **No behaviour should be in this class.** This is because the class by itself is
  tied into the Spring framework which imposes constraints on your ability to write unit tests against it.
  Instead, you should _immediately_ delegate the act of ingesting a HTTP request and producing a HTTP
  response to the provided static instance of RequestHandler.  
  
- The RequestHandler is a class which provides the outermost internal layer of your API. It interacts with
  the raw, wild, brutal HttpRequetReceiver, providing an abstraction layer behind which your domain logic can
  grow and prosper :). I recommend that you use this class to extract the appropriate domain-specific data
  and pass it down to a lower layer of the API for domain-specific processing i.e. "business logic". It
  should then receive data back from the domain-specific layer and interpret it in the technical context
  of HTTP.

- The HttpRestClient is a class which is unused in the template. It's purpose is to provide an abstraction
  layer for making HTTP requests. Consider the abstraction layer within your design at which you would like
  to make HTTP requests, and make them there.