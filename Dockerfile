FROM openjdk:17
EXPOSE 9090
ADD target/feedbackhub.jar feedbackhub.jar
ENTRYPOINT [ "java","-jar","/feedbackhub.jar" ]