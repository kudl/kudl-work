FROM openjdk:11-jdk-slim

LABEL maintainer="boot@kudlwork.com"

VOLUME /tmp

ENV JVM_OPTS -server -Duser.timezone=Asia/Seoul -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -XX:MaxRAMPercentage=60 -XX:+UnlockExperimentalVMOptions -XX:+UseZGC

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

CMD ["/bin/sh", "-c", "java --add-opens java.base/jdk.internal.misc=ALL-UNNAMED -Djava.security.egd=file:/dev/./urandom $JVM_OPTS -jar app.jar"]

EXPOSE 8080
