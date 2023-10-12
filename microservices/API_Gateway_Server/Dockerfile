FROM openjdk:11
EXPOSE 8088
ADD target/API_Gateway_Server-0.0.1-SNAPSHOT.jar API_Gateway_Server.jar
LABEL authors="Skander"

ENTRYPOINT ["java", "-jar","API_Gateway_Server.jar"]