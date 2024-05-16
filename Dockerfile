FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/tictactoe-1.0.jar"]
