#Following command is user to inherit this docker file from "openjdk dockerfile"
FROM openjdk:8

#Following command tells DevOps team to expose port 8080
EXPOSE 8080

# Following command is used to copy jar file from local computer to container  
COPY ./target/test.jar test.jar 

#Following command is used to run the jar file 
CMD ["java","-jar","test.jar"]
