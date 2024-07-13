# Etapa de build
FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Etapa de execução
FROM openjdk:17-slim
COPY --from=build /home/app/target/ForumHub-2.5.0-ForumHub.jar /usr/local/lib/ForumHub.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/ForumHub.jar"]