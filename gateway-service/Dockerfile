FROM amazoncorretto:11-alpine-jdk
MAINTAINER sridhar2193@gmail.com
COPY target/gateway-service.jar /opt/lib/gateway-service.jar
ENTRYPOINT ["java", "-jar", "/opt/lib/gateway-service.jar"]
EXPOSE 8765