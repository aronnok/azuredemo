FROM openjdk:8u212-jdk-alpine3.9

USER root

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk     

COPY ./microservices/gateway-ms/target/gateway-ms-0.0.1.jar gateway.jar
RUN sh -c  'touch  gateway.jar'
ENTRYPOINT ["java","-jar","gateway.jar"]

EXPOSE 8888
