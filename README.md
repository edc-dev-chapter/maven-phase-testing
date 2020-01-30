# maven-phase-testing

## Featuring with

* Enables multilevel testing [("TestPyramid")](https://martinfowler.com/bliki/TestPyramid.html), where tests are split into two groups, low-level unit tests and high-level integration tests
* Applies and simultaneously handles [JUnit 4](https://junit.org/junit4), [JUnit 5](https://junit.org/junit5) and [TestNG](https://testng.org/doc/index.html) frameworks 
* There is a possibility to execute tests, for one or both groups, in the failsafe mode
* There is a possibility to exclude tests, from one or both groups
* There is a possibility to narrow tests, from one or both groups, to WIP tests

## Preparing Maven

Tests are split into two groups which are executed in separate [Maven phases](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).
An execution in separate plugins enables independent management of each test group.
  * Unit tests in the "test" phase by [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin)
  * Integration tests in the "verify" phase by [Maven Failesafe Plugin](https://maven.apache.org/surefire/maven-failsafe-plugin)

### Multiple tests frameworks support

In order to detect and process distinct  tests frameworks, dedicated frameworks providers need to be specified explicitly as plugins dependencies (the same dependencies in both plugins).
Additionally there is a need to exclude JUnit tests handling from TestNG provider, which by default supports JUnit as well.
## Marking tests

Unit and integration tests are marked and separated on the basis of specific naming patterns.
There is no additional configuration needed.
> Unit tests names need to be compliant with the default Maven Surefire Plugin [includes pattern](https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#includes).

> Integration tests names need to be compliant with the default Maven Failesafe Plugin [includes pattern](https://maven.apache.org/surefire/maven-failsafe-plugin/integration-test-mojo.html#includes).  

### Examples

#### Unit test
```java
class ExampleTest {
    ..
}
```

#### Integration test
```java
class ExampleIT {
    ..
}
```

## Failsafe mode

Set through custom [`Java system properties`](https://docs.oracle.com/en/java/javase/11/tools/java.html). By default executions are not failsafe.
* **-DtestFailureIgnoreITs** - ignores failures for integration tests
* **-DtestFailureIgnoreUTs** - ignores failures for unit tests
* **-DtestFailureIgnore** - ignores failures for unit and integration tests

### Examples

#### For unit tests
```bash
$ mvn -DtestFailureIgnoreUTs ..
```

#### For integration tests
```bash
$ mvn -DtestFailureIgnoreITs ..
```

#### For unit and integration tests
```bash
$ mvn -DtestFailureIgnore ..
```

## Exclusion

Set through [`Java system properties`](https://docs.oracle.com/en/java/javase/11/tools/java.html). By default there are no executions.
* **-DskipITs** - skips integration tests (Maven Failsafe Plugin property)
* **-DskipUTs** - skips unit tests (custom property)
* **-DskipTests** - skips unit and integration tests (Maven Surefire Plugin property)

### Examples

#### Skips unit tests
```bash
$ mvn -DskipIUs ..
```

#### Skips integration tests
```bash
$ mvn -DskipITs ..
```

## WIP narrowing
Test needs to be marked by an annotation.
* JUnit 4 tests marked by the class and method level @Category annotation.
```java
import org.junit.experimental.categories.Category;
import pl.edc.dc.UnitTest;

@Category(WipTest.class)
public class JUnit4Test {
    ..
}
```
* JUnit 5 tests marked by the class and method level @Tag annotation.
```java
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("pl.edc.dc.WipTest")
class JUnit5Test {
    ..
}
```
* TestNG test marked by the groups attribute of the class and method level @Test annotation.
```java
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test(groups = {"pl.edc.dc.WipTest"})
public class TngTest {
    ..
}
```

Activated through a dedicated [`Maven build profile`](https://maven.apache.org/guides/introduction/introduction-to-profiles.html) for the given phase.
* **test-wip** - integration tests
* **verify-wip** - unit tests

### Examples

#### For unit tests
```bash
$ mvn -P test-wip ..
```

#### For integration tests
```bash
$ mvn -P verify-wip ..
```

#### For unit and integration tests
```bash
$ mvn -P test-wip,verify-wip ..
```

# Running tests

### Implicitly inside Maven lifecycle phases

#### Unit tests
```bash
$ mvn test|package
```

#### Unit and integration tests
```bash
$ mvn verify|install|deploy
```

### Explicitly through Maven plugin goals

#### Only unit tests
```bash
$ mvn surefire:test
```

#### Only integration tests
```bash
$ mvn failsafe:integration-test
```

# GitHub Actions workflow example
An example application in the [GitHub Actions](https://help.github.com/en/actions/automating-your-workflow-with-github-actions) workflow as CI (continuous integration) pipeline.
The workflow runs page and [pipeline.yml](.github/workflows/pipeline.yml).

# References
* https://semaphoreci.com/community/tutorials/how-to-split-junit-tests-in-a-continuous-integration-environment
* https://www.mkyong.com/unittest/junit-categories-test
* https://www.javaworld.com/article/2074569/core-java/unit-and-integration-tests-with-maven-and-junit-categories.html
* https://paucls.wordpress.com/2014/02/19/using-junit-categories-to-group-tests
* https://www.testwithspring.com/lesson/running-integration-tests-with-maven
* https://confluence.atlassian.com/clover/using-with-surefire-and-failsafe-plugins-294489218.html
* https://stackoverflow.com/questions/6612344/prevent-unit-tests-but-allow-integration-tests-in-maven
* https://books.sonatype.com/mcookbook/reference/ch07s04.html
* http://tomaszdziurko.com/2013/01/running-unit-tests-integration-tests-separately-maven-testng
