FROM openjdk:10-jdk
VOLUME /tmp
COPY target/java10-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]