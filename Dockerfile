FROM amazoncorretto:8-alpine-jdk

COPY target/sd-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]