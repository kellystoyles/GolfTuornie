FROM --platform=linux/arm64 eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]