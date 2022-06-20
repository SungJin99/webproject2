FROM mcr.microsoft.com/openjdk/jdk:11-ubuntu

ADD ./target/museum-reservation-*.jar /usr/src/myapp/museum-reservation.jar

EXPOSE 8080

WORKDIR /usr/src/myapp
CMD ["java", "-jar", "./museum-reservation.jar"]