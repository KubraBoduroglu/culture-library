# ABOUT THIS MICROSERVICES PROJECT

* This project allows to save and take notes about books you read, movies you watch.   
* Only API that open to outer word is LibraryAPI. LibraryAPI calls BookAPI with feign client.  

## TODO

* What can you use instead of eureka server? 
  * docker-compose for services you don't change much + application-LOCAL.yml for you debug  
  * Or application-LOCAL.yml for every service + run from ide
* (https://gemini.google.com/app/1bd058cd678bc9b3)
* application-LOCAL.yml dosyanı .gitignore'a ekle
* swagger api doc

## Install

Clone the project

```bash
  git clone https://github.com/KubraBoduroglu/culture-library.git
``` 

Go to the project directory

```bash
  cd culture-library
```

Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm run start
```


## Usage

* Run library service and create new library.

````bash
POST http://localhost:8080/v1/library/
Request Body:
{id}

````

* Send this id and an isbn that doesn't in library to create new record in library.
* Default values should be inserted if no valid isbn sent. 

````bash
PUT http://localhost:8080/v1/library/
Request Body:
{id}
{isbn}

````

* Check if books added in the library.

````bash
GET http://localhost:8080/v1/library/{id}

````

## DEVELOPMENT DOCUMENTATION

### ADD EUREKA SERVER TO PROJECT

* Eureka Server is a service registry,a service discovery tool that allows services to find and communicate with each other
* EurekaServerApplication should have the '@EnableEurekaServer' annotation in eureka-server module.  
* eureka-server module should have the 'spring-cloud-starter-netflix-eureka-server' dependency.  
* Other modules needed '@EnableEurekaClient' or ' @EnableDiscoveryClient' before, but not anymore.  
* Other modules should have the 'spring-cloud-starter-netflix-eureka-client' dependency.
* Other modules should have the 'eureka.client.service-url.default-zone' in application.properties.  

* Every eureka client has a local service registry. And even if eureka server not up and running these client services can communicate with each other using local service registries. It is  called  a fallback mechanism. If ip ports of the services change this solution doesn't work anymore. 

### ADD FEIGN CLIENT TO PROJECT

* Services that communicate with each other needs to have 'spring-cloud-starter-openfeign' dependency.  
* '@FeignClient' annotation should be used by clients.  
* Feign Client is an interface.  
* '@EnableFeignClients' annotation should be used by clients.  

### FEIGN CLIENT ERROR HANDLING

* RetrieveMessageErrorDecoder should be added to LibraryServiceApplication.class to handled by Spring Boot.
* Record creates immutable final classess with constructors and getter setters. Allows us to get rid of boilerplate code.  
* Why use Kotlin instead of Record for entities? 
  * Since Record is final, it cannot be used by Spring JPA. Spring JPA needs one constructor without parameters.  
  * Record cannot be extended.

### FAULT TOLERANCE AND FALLBACK METHODS

* Another way for fault tolerance is fallback methods with resilience4j.
* resilience4j dependency, `CircuitBreaker` annotation and fallback methods were added.
* Creating different fallback situations for different errors.
* Netflix Hystrix is deprecated, used resilience4j.
* Parameters of fallback methods are always feign client parameters and exception message.
* Default values should be inserted if no valid isbn sent.

### WHY KOTLIN?
* Default immutability. 
* No need for Lombok. No headaches for lombok version incompatibility and lombok generated classes.

------------  

## RESOURCES

1. [Spring Boot Microservices Project Example - Part 3 | Service Discovery](https://youtu.be/0TQliqoX6Kc?si=Szqo5KhgyXZUqPW-&t=209)  
2. [[TechThursday] - Microservice #2 - Spring Cloud Eureka Server/Client, Feign Client](https://www.youtube.com/live/Iv4v_1rdC9E?si=MlI8ZWQKcQCwY8XY)
3. [[TechThursday] - Microservice #3 - Spring Boot Feign Client Error Handling & Fault Tolerance](https://www.youtube.com/live/k9UTf8aaT44?si=ZFGs7FT3ki8UosRg)
4. [resilience4j](https://resilience4j.readme.io/docs/getting-started)