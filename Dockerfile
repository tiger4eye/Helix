FROM openjdk:8-jdk-alpine
EXPOSE 8081
VOLUME /tmp
#ADD target/helix-web.jar helix-web.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=container", "-jar","helix-web.jar"]
