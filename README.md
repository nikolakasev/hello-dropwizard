# hello-dropwizard
## How to run and test
To test the API locally, run the integration tests:
```shell script
mvn test
```
To build a "fat" JAR file, run:
```shell script
mvn package
```
Once built, start the API locally by running:
```shell script
java -jar target/hello-dropwizard-1.0-SNAPSHOT.jar server config.yml
```
## To think about
- The API has an admin endpoint listening on 8081 (provided by Dropwizard by default), investigate the potential attack surface
- How to collect the metrics from http://localhost:8081/metrics, push them to Graphite instead using the graphite reporter instead?
## Out of scope due to the time constraint
- No CI/CD pipeline, currently version is hard-coded to 1.0 snapshot
