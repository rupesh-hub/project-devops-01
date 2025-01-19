# 1. BUILD STAGE
FROM maven:3.8.7-openjdk-18 AS BUILD
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# 2. RUNTIME STAGE
FROM amazoncorretto:17

ARG PROFILE=dev
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=BUILD /build/target/backend-*.jar /app/

EXPOSE 9191
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}
ENV DB_URL=jdbc:mysql://mysql:3306/test_db

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL} backend-${JAR_VERSION}.jar

# cd backend
# docker build -t rupesh1997/backend:1.0.0 -f ../docker/backend/Dockerfile .
# docker run -d --network devops -p 9191:9191 --name backend  rupesh1997/backend:1.0.0
# docker network create --driver bridge devops
# docker network ls
    # - 41ec1dc71d2d

# Running backend with mysql db
# docker run -d -p 9191:9191 --name backend --network devops -e MYSQL_HOST=mysql -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DB=test_db rupesh1997/backend:1.0.0