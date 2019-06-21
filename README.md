# ah-poc-papi-springboot-archetype
Aimless-Hammer PAPI Springboot Maven Archetype Showcase

## Summary

PAPI archetype that tries to showcase the potential and possible configurability of Maven archetypes (including Apache Velocity templating)


## Install Maven archetype locally

The archetype needs to be build and installed locally, as it's currently not available in any Maven repository.

`mvn install`

## Generate a new project from this archetype

Generate by using interactive mode (queries for any missing parameters):
```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1
```


Generate by passing missing required parameters into archetype generator (leaves `teapot-enabled` to default value `n`):
```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1 \
	-DgroupId=com.aimless-hammer \
    -DartifactId=test-papi \
    -Dversion=0.0.1 \
    -Dpackage=com.aimless-hammer \
    -Dapp-name=TestPapi \
    -Dresource-name=balance	
```


Generate by passing all parameters (including parameters that have default values) into archetype generator:
```
mvn archetype:generate \
	-DarchetypeGroupId=com.aimless-hammer \
	-DarchetypeArtifactId=ah-poc-papi-springboot-archetype \
	-DarchetypeVersion=0.1 \
	-DgroupId=com.aimless-hammer \
    -DartifactId=test-papi \
    -Dversion=0.0.1 \
    -Dpackage=com.aimless-hammer \
    -Dapp-name=TestPapi \
    -Dresource-name=balance \	
    -Dteapot-enabled=true	
```

## What does this archetype do?
All interesting parts of this archetype are stored within 
* `src/main/resource/archetype-resources` - which stores the actual app that will be used as a template for the generator
* `src/main/resource/META-INF/maven/archetype-metadata.xml` - which defines any additional required properties and the files that should be copied into the archetype
    * see [Maven Archetype Descriptor](https://maven.apache.org/archetype/archetype-models/archetype-descriptor/archetype-descriptor.html)


Features:
* This archetype will generate a simple executable SpringBoot project and replace any [Apache Velocity](https://velocity.apache.org/) template strings
* It will apply the correct package name, group ID and artifact ID
* It will name the classes according to the `app-name` parameter
* It will name the SpringBoot resource according to the `resource-name` parameter
    * The resource response and the internal logging are also affected by this
* It will conditionally create an additional SpringBoot resource `/teapot` if the `teapot-enabled` parameter is set to `y`, `yes` or `true`
    * The `teapot-enabled` parameter has a default value of `n`, so needs to be explicitly overwritten.