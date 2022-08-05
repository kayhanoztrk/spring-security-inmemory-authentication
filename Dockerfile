FROM openjdk:8-jdk-alpine
WORKDIR /src/uygulamam
COPY /target/sample-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
CMD ["java","-jar","app.jar"]