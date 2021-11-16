FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD C:/devops/projects/timesheet-devops1/target/timesheet-devops1-1.0 timesheet-devops1-1.0
COPY . .
ENTRYPOINT ["java","jar","/timesheet-devops1-1.0.jar"]