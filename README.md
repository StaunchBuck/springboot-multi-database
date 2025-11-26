# Multi-Database Spring Boot App

## Overview
This Java Spring Boot application demonstrates using two datasources in the same application: one managed by JPA/Hibernate and a second accessed via plain JDBC. Intended for learning and small integration scenarios.

## Tech stack
1. Java (JDK 17+ recommended)
2. Spring Boot (Maven)
3. JPA / Hibernate (first datasource)
4. Plain JDBC (second datasource)
5. PostgreSQL and MySQL (examples)

## Project layout
1. `src/main/java` \- application code, configuration and datasource beans  
2. `src/main/resources` \- Spring Boot properties (`application.properties`) and other resources

## Configuration
1. Provide datasource credentials and driver class names in `application.properties`. Use distinct property prefixes for each datasource (for example `spring.datasource.jpa.*` and `spring.datasource.jdbc.*`).  
2. When using HikariCP (default in Spring Boot), make sure the pool-specific `jdbc-url` properties are bound if you set `driver-class-name`. Example keys to set:
   - `spring.datasource.jpa.hikari.jdbc-url`
   - `spring.datasource.jdbc.hikari.jdbc-url`  
   Use valid `jdbc:...` URLs for your PostgreSQL and MySQL instances.

## Running
1. Build:
   1. `mvn -DskipTests package`
2. Run:
   1. `mvn spring-boot:run`  
   or run the generated JAR:
   1. `java -jar target/<artifact>.jar`

## Notes on keeping the app alive
1. If the app is a web application, include the web starter dependency so an embedded servlet container keeps the JVM alive:
   - Add `spring-boot-starter-web` to `pom.xml`.
2. If the app is a non-web worker, provide a long-running bean (for example a `CommandLineRunner` that waits on a latch) to prevent the JVM from exiting immediately.

## Troubleshooting
1. Symptom: application starts then exits immediately (process ends with code 0).  
   - Cause: no web server and no non-daemon threads.  
   - Fix: add web starter or implement a long-running runner.
2. Symptom: embedded server starts but Spring fails to initialize datasource/Hikari errors.  
   - Cause: Hikari requires the `jdbc-url` to be bound when `driver-class-name` is present.  
   - Fix: set the Hikari-specific `jdbc-url` properties for each datasource (see Configuration above).

## Example placeholders
1. PostgreSQL JDBC URL: `jdbc:postgresql://localhost:5432/yourdb`  
2. MySQL JDBC URL: `jdbc:mysql://localhost:3306/yourdb`  
3. Replace usernames and passwords with secure values (do not commit secrets).

## Testing
1. Provide integration tests that bootstrap each datasource separately and validate connectivity.  
2. Use profiles to switch between local and CI database settings.

## License
Specify your project license in `LICENSE` if needed.
