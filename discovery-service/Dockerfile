FROM amazoncorretto:11-alpine-jdk
MAINTAINER sridhar2193@gmail.com
COPY target/discovery-service.jar /opt/lib/discovery-service.jar
ENTRYPOINT ["java", "-jar", "/opt/lib/discovery-service.jar"]
EXPOSE 8761