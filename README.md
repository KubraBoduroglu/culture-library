# ABOUT THIS MICROSERVICES PROJECT

* This project allows to save and take notes about books you read, movies you watch.   
* Only API that open to outer word is LibraryAPI. LibraryAPI calls BookAPI with feign client.  

## DEVELOPMENT NOTES

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

### EXCEPTION HANDLING

* Record creates immutable final classess with constructors and getter setters. Allows us to get rid of boilerplate code.  
* Why use Kotlin instead of Record for entities? 
  * Since Record is final, it cannot be used by Spring JPA. Sprin JPA needs one constructor without parameters.  
  * Record cannot be extended.  
*


------------  

## RESOURCES

1. [Spring Boot Microservices Project Example - Part 3 | Service Discovery](https://youtu.be/0TQliqoX6Kc?si=Szqo5KhgyXZUqPW-&t=209)  
2. [[TechThursday] - Microservice #2 - Spring Cloud Eureka Server/Client, Feign Client](https://www.youtube.com/live/Iv4v_1rdC9E?si=MlI8ZWQKcQCwY8XY)  