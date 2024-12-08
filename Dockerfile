FROM amazoncorretto:17-alpine-jdk

ADD target/qride-notifications.jar qride-notifications.jar
ENTRYPOINT ["java", "-jar", "qride-notifications.jar"]