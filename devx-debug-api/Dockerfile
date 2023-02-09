FROM openjdk:11-jre-slim as builder

# LABELS
LABEL MAINTAINER="platform engineering"
LABEL engineer="bryan oakley-wiggins"
LABEL version="0.0.1"
LABEL description="basic image for smoke test app"

WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN true
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:11-jre-slim
WORKDIR app
COPY --from=builder app/dependencies/ ./
RUN true
COPY --from=builder app/spring-boot-loader/ ./
RUN true
COPY --from=builder app/snapshot-dependencies/ ./
RUN true
COPY --from=builder app/application/ ./
RUN true
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

CMD java -XX:+PrintFlagsFinal $JAVA_OPTIONS1 $JAVA_OPTIONS2 -jar /app/*.jar --spring.cloud.bootstrap.enabled=false --spring.config.location=/app/config/
