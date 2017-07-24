# example-service-poc
example service poc with docker, rest and jus queue

# Unit Tests
You can run unit tests from command line with:
`mvn clean test`
This will run the tests in the default `target/test-classes` folder.

# Integration Tests
You can run integration tests from command line with:
`mvn clean test -Pintegration-test`
This will run the tests in the custom `target/integration-test` folder.

# Current Unit and Integration Test Configuration Drawback
Unfortunately the current configuration makes running the tests from the IDE virtually impossible. 
At least IntelliJ Idea cannot, decide are the correct test sources and resources folders.  

