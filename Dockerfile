#define base docker image 
FROM openjdk:17
LABEL maintainer="employee.net"
ADD target/EmployeeManagmentSystem-0.0.1-SNAPSHOT.jar employeeManagmentSystem-rest.jar
ENTRYPOINT ["java","-jar","/employeeManagmentSystem-rest.jar"]
EXPOSE 8080
