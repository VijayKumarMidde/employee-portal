# Employee portal
A simple REST API based employee portal

Backend developed using Java EE technologies like Spring and JPA with MySQL db

Frontend developed using Node.js and Angular.js

## Modules overview
employee-api: REST API module

employee-entity: JPA module

employee-service: Core business logic module

employee-web: Frontend module


## How to build?
```
# Build project

# TODO: add a root pom.xml to build the following modules in order
$ cd <ProjectRoot>/employee-entity/
$ mvn clean install

$ cd <ProjectRoot>/employee-service/
$ mvn clean install

$ cd <ProjectRoot>/employee-api/
$ mvn clean install

# deploy generated employee-api.war located in target folder in apache tomcat
# TODO: add deploy instuctions for REST service

# build and run web service
$ cd <ProjectRoot>/employee-web/
$ grunt serve
```
