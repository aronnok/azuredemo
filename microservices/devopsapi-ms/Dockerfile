FROM openjdk:8u212-jdk-alpine3.9

USER root





ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk     

COPY target/devops-api-0.0.1.jar devops-api.jar
RUN sh -c  'touch  devops-api.jar'
ENTRYPOINT ["java","-jar","devops-api.jar"]


EXPOSE 8889
