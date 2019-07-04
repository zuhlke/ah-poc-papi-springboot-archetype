# ux interview results

## Interview 1: An intern

- Working against commit 9c8c12d56306da2acff4c24c674a6942e61cac08

- Rob facilitating with a 30 minute tactical substitution from the legendary Al Hall

### Profile

- Hasn't used Java before, other than for a job interview. Inevitably has no idea about spring or mockito either.

- Is rusty, having just finished university, studying Engineering at Cambridge, specialising in information
  engineering.

- Has built a simple REST API before

- Has used HTTP works

- Isn't familar with any navigation, refactoring or suggestion shortcuts in IntelliJ

- Has written automated tests before, although not an experienced practitioner

### Observations

- Not sure what to do after reading the task description

- [Quote] "Where should I implement this?"

- First thing he does is look at the file structure, including the scripts and even the pom.

- Starts reading the product readme, named README.md.

- Upon reaching the section of the readme instructing the reader to immediately go and run the tests, he
  looks through the files, looks at the script "run-tests", hesitates for a moment, then opens the terminal in
  intellij and runs "./run-tests". He watches them pass, then goes back to reading the README.
  
- Looks in src/. The first file he opens is HttpRequestReceiver, which is says is because he was reading about it
  in the README, in the "classes" section.

- Uses cmd-space to search for "epidermis". Looks at a few diagrams on wikipedia.

- Appears initially confused by the phrase "outermost internal layer".

- [Intervention] I explain the purpose of doing this interview and what we hope to get out of it.

- He then takes his first look at Main, then springbootApplication, then back to the README.

- Goes to the HttpRequestReceiver and reads the comment on top of the class.

- Uses ctrl-shift-t and successfully navigates to the tests.

- Reads the class from top to bottom. Starting with the @After and @Before, moving down through the two tests,
  including their comments.
  
- When I ask him what he thinks, he says "No idea", and tells me that he hasn't done Java before.

- Has a look at the API-README.

- Looks at the .iml but has no idea what it is.

- He does `git init`, then `git status`, then `git add .` then `git commit -m "first commit"`.

- He searches "springboot application" with cmd-space, ditches that, and in google searches for "springboot".
  He goes to the springboot docs from pivotal, then moves to a pivotal blog post, and then to a video of
  a conference speaker talking about springboot.
  
- He watches the video, I show him how to turn on captions, it's okay for a bit, but he goes and gets his
  headphones to get more out of it. He's comparing the pom in the video with the pom in the project. He
  stops watching after a while.
  
- He goes to the intellij terminal and runs `./start-server`. Copying what was done in the video, he opens a
  browser window and goes to localhost:8080, which gives him a whitelabel error, the same as in the video.
  
- He asks how to stop the server and I say "ctrl-C", which he does.

- He goes back to the product README and reads the "classes" section. Looks at Main, looks at the
  SpringbootApplication.start static method, goes to the SpringbootApplication class to find it, and studies
  it for a bit.
  
- Looks again at the classes section of the README. He looks at the files in resources/ and seems
  uninterested.

- Goes to RequestHandlerTest and reads it.

- He now realises that the api package contains other classes and opens it. He goes to HttpRestClient.

- Looks at RequestHandler and reads the comment on top of the class.

- [Quote] As he's looking at the RequestHandler class, I ask him what he's doing right now. He responds with
  "I'm trying to figure out the relationships" and gestures with the mouse towards the classes in the main package.

- He goes again to look at the HttoRestClient.

- [Quote] When I ask him what he thinks the HttpRestClient is for, he says "it's not quite clear". He then
  searches using cmd-space for "REST HTTP" and finds himself on the wikipedia page.

- After reading it for a while, he closes the page and goes back to the code, reading the HttpRestClient again.

- He opens ReactiveRestClient and reads that for a while. He switches between the two classes, studying them.

- After some more back-and-forth switching, he goes to the RequestHandler class and starts reading the postSomeData
  method.

- Reads the README again from start to finish.

- Reads the comment on the HttpRestClient class. Navigates to tests, reads comment on tests and then reads the test
  code. Looks around at the supporting classes in the integration.client test package.

- He takes pen and paper and navigates to the README. He starts drawing an approximate class diagram for the
  template with boxes and lines:
```
  HttpRequestReceiver
           |
           v
     RequestHandler
     |            |
     v            v
  Domain 1      Domain 2
```

- He draws another diagram regarding his understanding of what he needs to do.

```
Mobile users --[ 1 ]------------> me --[ 2 ]---> backend
             <-[ ACTIVATE-code ]-    <-[ code ]-  
```

- Upon questioning about the endpoints and their behaviour, in part using the tests, he demonstrates a functional
  understanding of the entry point, he can change the path and update the test to reflect that, as well as identify
  the HTTP methods used.

- When I ask him what he thinks of the Mockito call, he doesn't quite understand it, but is actually quite close.
  When I explain it he seems to understand, and when I ask him to demonstrate how he'd write a new test with mocks
  he can do it correctly.
  
- He said it took some time for him to understand the structure of the source files.

- He said the README was really helpful, especially the classes section.

- He said the video was not helpful due to the assumption that he knew Java, although from what I saw it seemed
  like seeing what a springboot app looks like when you run it and how to exercise it helped him gain some
  familiarity with it.

### Changes to be made

- In the comment at the top of the classes with tests demanding the user to go run the tests, specify that
  they should read and understand the tests for _this_ class.

- The wording of the HttpRequestReceiver documentation is not friendly to a non-native english speaker and should
  be simplified.

- Expand the classes section of the README to cover all of the classes.

- Add a test classes section to the README.

- Add a section to the README on how to manually test it using the browser.

- Add manual testing scripts.

### Hypothetical ideas

- Documentation annotations