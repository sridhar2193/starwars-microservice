FROM amazoncorretto:11-alpine-jdk
MAINTAINER sridhar2193@gmail.com
COPY target/starwars-service.jar /opt/lib/starwars-service.jar
ENTRYPOINT ["java", "-jar", "/opt/lib/starwars-service.jar"]
EXPOSE 8081