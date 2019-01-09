FROM openjdk:8
ADD target/DevOps-MS.jar DevOps-MS.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "DevOps-MS.jar"] 