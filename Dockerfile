FROM openjdk:8-jdk-alpine
EXPOSE 8082
VOLUME /tmp
COPY target/timesheet-devops1-1.0.jar /var/lib/docker/tmp/buildkit-mount797590078/target/timesheet-devops1-1.0.jar
ENTRYPOINT ["java","jar","/timesheet-devops1-1.0.jar"]