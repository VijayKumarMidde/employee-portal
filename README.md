# Employee portal
A simple REST API based employee portal

Backend developed using Java EE technologies like Spring and JPA with MySQL db

Frontend developed using Node.js and Angular.js

## Modules overview
employee-api: REST API module
employee-entiry: JPA module
employee-service: Core business logic module
employee-web: Frontend module

## How to build?
```
# Build project
$ mvn clean install

# deploy generated employee-api.war located in target folder in apache tomcat
# TODO: add deploy instuctions for REST service

# build and run web service
$ cd employee-web/
$ grunt serve
```
