# Tic Tac Toe Game

## Project Overview
- Java 17 (developed with OpenJDK 17.0.9)
- Maven
- JUnit
- macOS 14.5

## How to run the game
There are 3 ways to run the game from the command line:
1. Run precompiled jar (Java JDK must be installed on your machine) ``java -jar target/tictactoe-1.0.jar``
2. Run using Docker
   - ``docker build -t tictactoe .``
   - ``docker run -i -t tictactoe``
3. Build and run the Maven project
   - Check if Maven is installed ``mvn -version``
   - cd into project folder
   - Run tests ``mvn test``
   - Build jar ``mvn package``
   - Execute jar ``java -jar target/tictactoe-1.0.jar``

4. Play Tic Tac Toe!