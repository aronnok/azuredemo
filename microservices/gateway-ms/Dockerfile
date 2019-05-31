FROM openjdk:8u212-jdk-alpine3.9

USER root

#RUN cd /usr/lib/jvm && \
#       ln -s java-1.8.0-openjdk-amd64 java

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk     

COPY  /home/vsts/work/1/a/*.jar gateway.jar
RUN sh -c  'touch  gateway.jar'
ENTRYPOINT ["java","-jar","gateway.jar"]


EXPOSE 8888
