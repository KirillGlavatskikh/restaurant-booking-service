FROM eclipse-temurin:17-jdk-jammy

COPY .gradle/ .gradle
COPY build.gradle ./

COPY src ./src

EXPOSE 8000