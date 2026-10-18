# Medical microservices

## Services

- `discovery-service`: Eureka service registry on port `8761`.
- `patient-service`: Patient API on port `8081`, registered with Eureka.

## Run the services

Start the discovery service first:

```bash
cd discovery-service
mvn spring-boot:run
```

Then start the patient service in another terminal:

```bash
cd patient-service
mvn spring-boot:run
```
