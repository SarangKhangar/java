Spring Cloud

It gives you many different libraries for implementing microservices

1] OpenFeign - use make REST calls 

Steps to use OpenFeign

1] Add dependency in pom.xml

2] Create an interface with an method matching signature of remote 

3] Enable feign client

 We want to assign unique name to every microservice and use that name to refer that microservice.
 It is by using 
 
   *Eureka : It service registry and discovery   server.
             Every mircosrvice register itsel fwith Eureka
             Eureka server typically runs on port 8761