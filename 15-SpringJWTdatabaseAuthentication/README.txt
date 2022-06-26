http Status Codes 

202    OK

401    UNAUTHORIZED

403    Forbidden (Authenticated but not allowed to access it)


This project uses database authentication


* Steps for applying  Spring Security

    Add dependency spring web security to pom.xml i.e.
    
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

By default one user with username : user 
and password : displayed on console : 0f9944bb-e374-4e87-b7c1-a503e73b99b8

Problem?
   Every time you run application new password is generated 
   
   Above is the default behaviour functinality of we are getting from spring security
   
 Solution 
   we want to have custom username and password 
   
   