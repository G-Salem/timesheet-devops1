FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD devops/projects/timesheet-devops1/target/timesheet-devops1-1.0.jar timesheet-devops1-1.0.jar
COPY . .
ENTRYPOINT ["java","jar","/timesheet-devops1-1.0.jar"]