# ux interview results

## Interview 1: An intern

- Working against commit 9bb676f448e202917f08ec38fe2106edd851c5ba

- Rob and Vlad facilitating

### Profile

- Hasn't used Spring before

- Hasn't built a REST API before

- Isn't familiar with how HTTP works

- Hasn't used Mockito before

- Isn't familar with any navigation, refactoring or suggestion shortcuts in IntelliJ

- Is familiar with Java, having used it in a previous internship

- Isn't familiar with automated testing

### Observations

- The first thing he did was look around the (main) source code, starting from Main. He expanded
  the test package without looking at any classes. Did not run anything or look at the command
  line.

- Was confused by the static field of type ConfigurableApplicationContext in SpringbootApplication.
  He said a comment would help.

- The Spring entry point was not clear to him at all. Me and Vlad had to intervene later a number of
  times to try to explain how it worked.

- Tried to manually create a run configuration in the IntelliJ GUI. Gave up on that, and successfully
  found a way to run the application from the editor.

- He tried to understand the program by making breakpoints, but seemed exasperated by the opaqueness
  of the entry point.
  
- Frequently goes to look at the Main class.

- [Intervention] I directed him towards the tests in order to try to understand the control flow of
  the program. Until this point he had not looked at the tests.
  
- [Quote] "I'm trying to figure out _where_ to do these things." In this statement, 'these things' refers
  to the task at hand where he needs to add some behaviour to the API.

- He seemed confused by the presence of non-test classes in the test source root.

- He understood and correctly described the scope of the 3 tests from the package names.

- [Task feedback] It wasn't entirely clear to him that he was writing the API, rather than the
  mobile or backend APIs.

- [Intervention] I had to intervene to tell him how to add an endpoint to a Springboot application.

- [Intervention] I told him about the way the request path is defined for springboot endpoints,
  because he couldn't figure it out. 
  
- He modifies the existing post/ endpoint to give it the path required by the task, rather than
  extending the API with a new endpoint. He doesn't run any tests to check if anything is broken.

- [Intervention] Me and Vlad try to explain the entry point of a Springboot REST API regarding the
  @RestController annotation and the request mappings.
  
- He tries to use curl to manually test the API from the command line. This is the first time he opened
  the command line. He can't get a post request to work and the way the requests are defined in the
  requirements makes him confused about how HTTP request bodies work. He tries the docs of curl but
  with no luck.

- [Intervention] After watching him try and fail to use curl to invoke the API via a post request, I
  suggest looking at the test suite.

- [Quote] "If I could just <find a way to manually test the API from the command line>..."

- It seems that he would really like to be able to manually test the API, just to check that it works.

- He is not familiar with Mockito and doesn't understand the way that the RequestHandler is stubbed in
  the server integration test.

- He is confused by the fact that the initial endpoints are called /get and /post, and it is not clear
  to him that the HTTP method bound to the RestController's methods is determined by the RequestMapping
  annotation that marks them. It also doesn't help that the methods on the RequestHandler are called
  get() and post(), which further confuses him into briefly thinking that the RequestHandler is some
  kind of HTTP client.

- He doesn't know which classes are owned and can be modified or extended by him. He googles the name of
  the owned rest client used in the integration tests, SpringHttpClient.

- [Intervention] I explain that SpringHttpClient is a class we've defined, which means that he is allowed
  to change it.

- He can't identify the scope of each test from the name of the test class.

- Changed the log call in his endpoint, but didn't change the method call to the RequestHandler.

- He created a new test for his new endpoint in the IntegrationTest class.

- [Intervention] I again have to explain how the Spring entry point works.

- He uses google to look at HttpServletRequest. He goes to the oracle java docs and scrolls through the
  list of public methods.

- [Quote] "An incoming call should have a body" He's referring to the fact that HttpServletRequest
  doesn't have a clear way of extracting the request body.

- [Intervention] He asks me for help with IntelliJ to find out the parameters for a method call. This
  is part of a general trend that he isn't familiar with the power of the IDE.
  
- Uses google to find method names before trying to look at auto-complete

- He finds the tests confusing because they don't have comments.

- [Intervention] His google searches are unfocused. I guide him with questions, although sometimes these
  are leading questions, to writing a better google search for solving his problem.
  
- He finds an answer for how to get the request body from a HttpServletRequest on stackoverflow. He copy
  and pastes from stackoverflow into the SpringController. He makes no attempt at using the indirection of
  the RequestHandler.

- [Intervention] I tell him that alt-enter can be used to sort out the dependency errors that pop up when
  he's copy-pasted the code in.
  
- He tries to import the SpringHttpClient from the test package into the SpringController. He looks at the
  RestClient, but doesn't use it. It doesn't seem like he understands the method names blockingGet versus
  reactiveGet.

- I call time-up after 2.5 hours.