# ah-poc-papi-springboot-archetype

Aimless-Hammer PAPI Springboot Maven Archetype Showcase

## Summary

PAPI archetype that tries to showcase the potential and possible configurability of Maven archetypes (including Apache Velocity templating).

## Install Maven archetype locally

The archetype needs to be build and installed locally, as it's currently not available in any Maven repository.

There is a script `./install-archetype-locally`.

The script just contains `mvn install`.

## Generate a new project from this archetype

There is a script `./generate-papi`, which is safe to call from any directory.

Usage: `./generate-papi <group id> <artifact id> <application name>`

If you don't use the script, you can still use the maven commands below.

#### Generate by using interactive mode (queries for any missing parameters)

```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1
```

#### Generate by passing missing required parameters into archetype generator

```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1 \
	-DgroupId=com.aimless-hammer \
    -DartifactId=test-papi \
    -Dversion=0.0.1 \
    -Dpackage=com.aimless-hammer \
    -Dapp-name=TestPapi
```

#### Generate by passing all parameters (including parameters that have default values) into archetype generator

```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1 \
	-DgroupId=com.aimless-hammer \
    -DartifactId=test-papi \
    -Dversion=0.0.1 \
    -Dpackage=com.aimless-hammer \
    -Dapp-name=TestPapi
```

## What does this archetype do?

All interesting parts of this archetype are stored within 
- `src/main/resource/archetype-resources` - which stores the actual app that will be used as a template for the generator
- `src/main/resource/META-INF/maven/archetype-metadata.xml` - which defines any additional required properties and the files that should be copied into the archetype
    - See: [Maven Archetype Descriptor](https://maven.apache.org/archetype/archetype-models/archetype-descriptor/archetype-descriptor.html)

- This archetype is intended to generate enough classes and structure to make it very obvious how to create APIs, while not generating too much and risking infringing
on the core domain of the APIs it intends to implement.

### Java files generated

If I call `./ah-poc-papi-springboot-archetype/generate-papi com.aimless-hammer example-papi ExamplePapi`, I get a folder called `example-papi`.

Here is the result of `tree example-papi/src/main/java/com/aimless_hammer/`

```
Robs-Computer:templating$ tree example-papi/src/main/java/com/aimless_hammer/
example-papi/src/main/java/com/aimless_hammer/
├── Main.java
├── SpringController.java
├── SpringbootApplication.java
└── papi
    ├── RequestHandler.java
    └── SapiRestClient.java

1 directory, 5 files
Robs-Computer:templating$ 
```

Here is the result of `tree example-papi/src/test/java/com/aimless_hammer/`

```
Robs-Computer:templating$ tree example-papi/src/test/java/com/aimless_hammer/
example-papi/src/test/java/com/aimless_hammer/
├── integration
│   ├── IntegrationTest.java
│   └── SpringHttpClient.java
└── unit
    └── RequestHandlerTest.java

2 directories, 3 files
Robs-Computer:templating$ 
```
### Supporting files

- Two scripts: `build-jar` and `run-tests`, which do what you might guess.

- A `README.md` with a lot of blanks.

- A `.gitignore` which ignores `target/` and `.idea/workspace.xml`.

## Troubleshooting

#### It generates too many files/duplicated files/files that it used to include but I deleted ages ago

- I believe this is a caching issue with the way local archetypes are published.

- I fixed this by specifying explicitly which files to include. You can see this in `src/main/resource/META-INF/maven/archetype-metadata.xml`.

#### After generating the project, IntelliJ can't access java.lang.String

- I found this a couple of times, although it seemed pretty random to me.

- I fixed it by going on project structure (cmd-;) and removing the project SDK(s) then readding whatever was required.
    - In the project structure dialog box, navigate to Platform Settings -> SDKs in the left panel, then use the '-' button to remove all the
      SDKs you don't think you need. IntelliJ should prompt you to readd them, or, if it doesn't, you can readd them yourself using the '+'
      button.