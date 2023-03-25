FROM amazoncorretto:11-alpine-jdk
MAINTAINER Rodolfo Ruiz Huidobro
COPY target/rrh-0.0.1-SNAPSHOT.jar RRH-App.jar
ENTRYPOINT ["java","-jar","/RRH-App.jar"]
