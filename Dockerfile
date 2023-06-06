#define base docker image
FROM openjdk:17
LABEL maintainer="subbu.net"
ADD target/donor-microservices-0.0.1-SNAPSHOT.jar donor-microservices.jar
ENTRYPOINT ["java", "-jar", "donor-microservices.jar"]
