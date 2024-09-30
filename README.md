# FeedbackHub

A feedback web application for Developers and community

This project is to teach the audience who wants to learn Spring Boot or Java.
I'll make an youtube video and a presentation for your reference.  
Video Link: https://youtu.be/B_PCGl_kdng
Presentation Link: [View on canva] (https://www.canva.com/design/DAFZubtuybI/fPlvL4OWE7iYOlop9wSreQ/view?utm_content=DAFZubtuybI&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink)

google doc file: (if you prefer to read doc instead md files)
Help and Support: [Linkedin: https://bit.ly/swapnilLinkedin](https://bit.ly/swapnilLinkedin)

## Technologies Used

1. Spring Boot (Java)
2. MySQL(Sql, google cloud), postgre sql
3. React (javaScript)

## Project Setup

To get Started we need to understand that we have to setup three things

1. Choosing and setting up IDE,VS code for Spring Boot, alternatively you can use Eclipse or STS [Start Here](https://spring.io/tools)

- download Visual Studio Code (https://code.visualstudio.com/)

2. Setting up Database, MySQL or mongoDB for data base connectivity.
   > spring boot comes with inbuit data storing service- Hibernate  
   > But it is temprorary Database, so choose one from above.

# Here's how you can connect a spring boot application with a MySQL database:

First, add the necessary dependencies to your project's pom.xml file:

```
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.21</version>
</dependency>
```

Next, create a new application.properties file in the src/main/resources directory and configure the database connection settings:

```
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=database_username
spring.datasource.password=database_password
spring.jpa.hibernate.ddl-auto=update
```

Create a data source bean in your Spring Boot application configuration class:

```
@Bean
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/database_name");
    dataSource.setUsername("database_username");
    dataSource.setPassword("database_password");
    return dataSource;
}
```

You can then use JPA (Java Persistence API) to interact with your MySQL database by defining Entity classes and repository interfaces.

# Here's how you can connect a Spring Boot Application with a PostgreSQL database:

First, add the necessary dependencies to your project's pom.xml file:

```
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
</dependency>
```

Next, write these configurations in application.properties file in the src/main/resources directory and configure the database connection settings:

```
#db-configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/Feedback-hub-db
spring.datasource.username=admin
spring.datasource.password=admin

# postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

```

# Setting up database in Docker

- Download and Install Docker from https://www.docker.com/products/docker-desktop/
- Run Docker useing shorcut on Desktop
- Open Docker terminal and run the following command to pull the PostgreSQL image from Docker Hub: docker pull postgres
- Once the Image is downloaded run this command in terminal to start PostgreSQL Server: docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=Feedback-hub-db --name=Feedback-hub-DB postgres
- You can see the Running Server in Docker Application
- Now run your Spring Boot Application.

# Here's how you can connect a spring boot application with a MongoDB database:

First, add the necessary dependencies to your project's pom.xml file:

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-mongodb</artifactId>
   <version>2.4.1</version>
</dependency>
```

Next, create a new application.properties file in the src/main/resources directory and configure the database connection settings:

Copy code

```
spring.data.mongodb.uri=mongodb://localhost:27017/database_name
```

# Setting up database in codeSpace

- for this we can use google cloud database on cloud sql, for now I have used a website nHost, they give you instant postgre sql.
- go to nhost ( nHost.io )
- go to settings after logging in
- you will get the database information to connect in database section
  [ss-img](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FVHfGOoNtpFOHgbhpjjr9%2Fuploads%2FbybsLqgQED77JYiQZytM%2Fimage.png?alt=media&token=13a62fc7-b68b-47c5-8429-b9942188aa40)

<p align="center">
  <img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FVHfGOoNtpFOHgbhpjjr9%2Fuploads%2FbybsLqgQED77JYiQZytM%2Fimage.png?alt=media&token=13a62fc7-b68b-47c5-8429-b9942188aa40" width="350" title="nhost database details">
</p>

Now configure you application.properties after adding dependencies

- postgres
- spring-boot-starter-data-jpa
- spring-boot-starter-web

copy and paste

```
server.port=9090


#db-configuration
spring.datasource.url=jdbc:postgresql://iwjhgmymtrnujcokdtrv.db.eu-central-1.nhost.run:5432/iwjhgmymtrnujcokdtrv

spring.datasource.username=postgres
spring.datasource.password=Swapnilsql@12



# spring data jpa
# postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

#mysql, uncomment below if using mysql
# spring.jpa.show-sql=true
# spring.jpa.hibernate.ddl-auto=update
# spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

## instructions

- spring boot initaliser
- add dependencies
- add databases
- create folder structure

## Setting up CI/CD Pipeline using Jenkins and Dockerizing Application

- Create Two files in Root Directory Named Jenkinsfile and Dockerfile

1. Here is how to configure Jenkinsfile write following code in the file

```
pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/{Branch Name}']], extensions: [], userRemoteConfigs: [[url: ' {GitHub Project URL} ']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    bat 'docker build -t {DockerHub Repo name}:feedbackhub-v1 .'
                }
            }
        }
        stage('Push Docker image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: '{Variabel Id}', variable: '{DockerHub Password Stored in Secrete Key use Jenkins Syntax Creator for Key}')]) {
                    }
                    bat 'docker push {DockerHub Repo Name}:feedbackhub-v1'
                }
            }
        }
    }
}
```
2. Here is how to configure Dockerfile write following code in the file

- First Write the Following Line in Pom.xml build tag. So that the jar file in target folder will be named as feedbackhub

```
<finalName>feedbackhub</finalName>

```
- Then write the following code in Dockerfile

```
FROM openjdk:17
EXPOSE 9090
ADD target/feedbackhub.jar feedbackhub.jar
ENTRYPOINT [ "java","-jar","/feedbackhub.jar" ]

```

## Adding Swagger to Application

- Add following dependecy in pom.xml

```
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.6.0</version>
</dependency>

```
- Now visit ``` http://localhost:9090/swagger-ui/index.html ``` to access Swagger UI