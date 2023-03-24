FROM amazoncorretto:11-alpine-jdk

MAINTAINER SD

EXPOSE 8080

COPY target/sd-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]