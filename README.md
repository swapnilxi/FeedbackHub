# FeedbackHub
A feedback web application for Developers and community  



This project is to teach the audience who wants to learn Spring Boot or Java.
I'll make an youtube video and a presentation for your reference.  
Video Link: https://youtu.be/B_PCGl_kdng
Presentation Link: [View on canva] (https://www.canva.com/design/DAFZubtuybI/fPlvL4OWE7iYOlop9wSreQ/view?utm_content=DAFZubtuybI&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink)
## Technologies Used 
1. Spring Boot (Java) 
2. MySQL(Sql)
3. React (javaScript)

## Project Setup
To get Started we need to understand that we have to setup three things 
1. Choosing and setting up IDE,VS code for Spring Boot, alternatively you can use Eclipse or STS [Start Here](https://spring.io/tools)
- download Visual Studio Code (https://code.visualstudio.com/)
2. Setting up Database, MySQL or mongoDB for data base connectivity.
> spring boot comes with inbuit data storing service- Hibernate   
But it is temprorary Database, so choose one from above. 



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
Here's how you can connect a spring boot application with a MongoDB database:

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
Create a MongoTemplate bean in your Spring Boot application configuration class:
- java

```
@Bean
public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
    MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));
    return new MongoTemplate(mongoDbFactory, converter);
}
```
You can then use Spring Data MongoDB to interact with your MongoDB database by defining document classes and repository interfaces.

# Setting up database in codeSpace
- for this we need Sql Server in codespace 
## instruction
- 

