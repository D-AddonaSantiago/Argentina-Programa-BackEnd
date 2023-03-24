FROM amazoncorretto:11-alpine-jdk

EXPOSE 3306

COPY target/sd-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]