# CrazyGateway


This is a "microservice" application intended to be part of a microservice architecture, please refer to the [Doing microservices with JHipster][] page of the documentation for more information.

This application is configured with Kafka dependency. Please runn following command

docker-compose -f src/main/docker/kafka.yml up -d

## Development

To start your application in the dev profile, run:

    ./gradlew

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].

## Building for production

### Packaging as jar

To build the final jar and optimize the CrazyGateway application for production, run:

    ./gradlew -Pprod clean bootJar

To ensure everything worked, run:

    java -jar build/libs/*.jar

Refer to [Using JHipster in production][] for more details.

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

    ./gradlew -Pprod -Pwar clean bootWar

## Testing

To launch your application's tests, run:

    ./gradlew test integrationTest jacocoTestReport

For more information, refer to the [Running tests page][].

### Code quality

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker-compose -f src/main/docker/sonar.yml up -d
```

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the gradle plugin.

Then, run a Sonar analysis:

```
./gradlew -Pprod clean check jacocoTestReport sonarqube
```

For more information, refer to the [Code quality page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./gradlew bootJar -Pprod jibDockerBuild

Then run:

    docker-compose -f src/main/docker/app.yml up -d

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 6.7.1 archive]: https://www.jhipster.tech/documentation-archive/v6.7.1
[doing microservices with jhipster]: https://www.jhipster.tech/documentation-archive/v6.7.1/microservices-architecture/
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v6.7.1/development/
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v6.7.1/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v6.7.1/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v6.7.1/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v6.7.1/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v6.7.1/setting-up-ci/


#See message from kafka

kafka-console-consumer --bootstrap-server localhost:9092 --from-beginning --topic EventType1



