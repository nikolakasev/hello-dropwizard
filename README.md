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
Using Postman, send the following payload to http://localhost:8080/search:
```json
{
	"departureAirport": "AMS",
	"destinationAirport": "VIE",
	"fromDate": "2021-08-21",
	"toDate": "2021-08-29"
}
```
The API will return a couple of flights matching the search criteria.
## To think about
- The API has an admin endpoint listening on 8081 (provided by Dropwizard by default), investigate the potential attack surface
- How to collect the metrics from http://localhost:8081/metrics, push them to Graphite instead using the graphite reporter instead?
- It seems that the default log setup uses UTC which is good, but have to check how to configure explicitly (-Duser.timezone=UTC)
- Understand the /metrics better, what KPIs are the most important and create a dashboard for them
## Out of scope due to the time constraint
- No CI/CD pipeline, currently version is hard-coded to 1.0 snapshot
- An extended validation of request messages (perhaps even a proper error data model?), currently a very rudimentary logic is present
