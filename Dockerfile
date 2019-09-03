FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/InternetProtocolNumberTracing-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]