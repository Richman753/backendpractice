FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

FROM eclipse-temurin:17-jre-alpine

COPY --from=builder /usr/src/app/target/*.jar /app.jar

EXPOSE 8081

ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
