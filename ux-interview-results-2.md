# ux interview results

## Interview 2: An intern

- Working against commit 9e8afac20ca4291e5cbb0af712d7a92b079725ab

- Rob facilitating

### Profile

- Hasn't used Spring before

- Hasn't built a REST API before

- Isn't familiar with how HTTP works

- Hasn't used Mockito before

- Isn't familar with any navigation, refactoring or suggestion shortcuts in IntelliJ

- Is familiar with Java, having used it in a previous internship

- Isn't familiar with automated testing

### Observations

- The first thing he does after reading the task description is google "How to handle a POST in java?"

- [Intervention] I tell him that the code for doing this is generated

- He opens the HttpRequestReceiver, but is still reading from the answer to his google query which he
  found on stackoverflow
  
- He reads the comment on the class

- He reads the comments on the two mapping methods

- He modifies the existing /some-data POST handler, using an if statement within that handler to check
  for the /activate-credit-card path.
  
- He goes to the RequestHandler and reads the comment on the class

- He does cmd-shift-t like the comment says and goes to the test

- He reads the comment on the test class and the two test assertions

- He looks back at the /some-data POST handler.

- [Intervention] I explain how the HTTP flow works in the task

- He googles "How to extract body from HttpServletRequest", and arrives at the same stackoverflow
  page that the intern in the first experiment came to.

- He looks through the answers but says he's stuck

- [Intervention] I advise him on which code to copy from the stackoverflow page, and how extracting
  the request body is important for the task

- He looks at the SpringbootApplication class and then at Main

- He copy-pastes the stackoverflow code into the /some-data POST handler.

- [Intervention] I tell him to use alt-enter to fix the dependency issues.

- In the compiler-error dependency confusion, he assigns the result of the body extraction to an
  Object, instead of a String.
  
- [Intervention] I tell him that he should assign the body to a String, not an Object.

- He tells me that he intends to do a small but of string parsing to get the last 5 digits of the
  card number from the request body.
  
- He searches on google for a method to truncate strings, he successfully finds the substring method.

- [Intervention] He's not taken into account the json format of the data or the spaces, so I remind
  him about that. This would suggest that json format familiarity should not be taken for granted.
  
- He uses the trim() method to despace the string before getting the last 5 digits with the substring
  method.
  
- He looks at HttpRestClient, and reads the comments at the top of the class. He asks me if the method
  reactivePost() sends a post request. I tell him it does.

- He looks to construct an instance of HttpRestClient in the /some-data handler.

- He passes the url into the constructor, which causes a compiler error - he's accidentally confused
  the constructor and the reactivePost() method. Unfortunately I think he's a bit stressed by this
  interview thing.

- [Intervention] I let him know he's confused the contructor and the method call. He facepalms,
  probably because he wouldn't have made that mistake if he wasn't stressed! I should really make
  this a better experience.

- He's not sure what a WebClient is. He types "WebClient" into the constructor, then deletes it.

- Sees the correct class in the intellij autocomplete, but doesn't fill it in.

- He googles "webclient spring", and starts reading the spring docs for the webclient.

- He makes a WebClient field and assigns it to WebClient.create().

- Successfully constructs a HttpRestClient and tries to call reactivePost. He correctly passes the
  url as the first argument, but then tries to pass the parsed last 5 digits of the mobile api's
  request body as the second argument.

- Using alt-enter he takes intellij's suggestion of changing the signature of reactivePost so that
  bodyType is a string.
  
- Sees the new errors in the HttpRestClient and goes to read more WebClient docs from spring.

- Tries to assign the result of reactivePost to a String. When it doesn't work he deletes it.

- The call is unassigned, and intellij raises an "unassigned mono instance" warning, which he
  googles.
  
- [Intervention] I tell him about using ctrl-alt-v to extract a variable in order to see the type of
  a statement.

- He looks again into the compile errors in the HttpRestClient.

- Is visibly confused by the type Class<T>.

- [Quote] Upon seeing the type ParameterizedTypeReference<T> he says "What the fuck is that", which I
  think is fair enough.
  
- [Intervention] I tell him about looking a tests to learn about how an object is intended to be used
  and show him the tests for the HttpRestClient.

- He makes a JsonBody class and copies in the content of TestJsonBodyType. He goes back to the
  HttpRestClientTest and looks at the test again. He reads the comment.
  
- [Quote] "Whaaat?!" is his resopnse to seeing the use of TestJsonBodyType.class as an argument to a
  method and the use of the reactiveGet method generally.
  
- He edits the toString method of JsonBody, which was copied from TestJsonBodyType. He changes it so
  that it matches the request body format that he needs to send to the backend, rather than the response
  body format he is expecting back from them. To me that seems quite fair enough - the variable is named
  poorly and the usage is not clear, especially due to the lack of an argument for the request body.
  
- He starts writing a constructor for JsonBody.

- He passes in JsonBody.class to the reactivePost. Upon seeing that there are no compiler errors, he's
  pleased.

- He looks at the RequestHandler and goes to the test with ctrl-shift-t.

- Goes back to the /send-data POST handler. In it, he tries to construct an instance of RequestHandler.

- He loks at the constructor of it and sees that the constructor takes a HttpRestClient.

- He googles "constructing a httpRestClient".

- [Intervention] I point out that he owns that class. Again, he facepalms.

- [Quote] "I already have one I swear". He recalls that he's already made of of these.

- He makes an instance field of type RequestHandler in the HttpRequestReceiver, using the field for the
  HttpRestClient he made earlier in order to contruct it.
  
- He calls getSomeData() on his new RequestHandler

- I call time after 1.75 hours because I have a meeting.

- I quickly asked him for feedback, and he said he'd like examples of a real API created from the
  template. He'd also said that in the task description he'd like to have examples including the
  names of classes to use and methods to call.

- He says he thought it would have been better if he'd used the tests more, and said it would've been
  better to have more direction towards using the tests.

### Changes to be made

- The HttpRestClient methods should have options for passing in a request body, and the bodyType
  parameter should be renamed as responseBodyType.
  
- Comments on the tests which tell the user how to run the tests immediately.

- Add methods to the HttpRestClient which include a request body parameter as a string.

- Guidance in every class to look at the PAPI Core Product README.

- Fill in the PAPI Core Product README with detailed information about how to develop and API using
  this template.

- Point them towards the documentation for the PAPI Core Product at the start.

- Have a comment in the mapping methods that effectively says "Don't put any more code in this method"
  and maybe also a "cmd-B" hint.
  
- Include a method for extracting the body of the HttpServletRequest in the HttpRequestReceiver or the
  RequestHandler.
  
### Hypothetical ideas

- Build an example "real" API using the template and refer to it in documentation. Also include a
  description of the API in a task format which refers to details like classes and methods.