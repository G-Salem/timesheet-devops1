FROM openjdk:8-jdk-alpine
EXPOSE 8082 
ADD target/timesheet-devops1-1.0.jar timesheet-devops1-1.0.jar
ENTRYPOINT ["java","jar","/timesheet-devops1-1.0.jar"]