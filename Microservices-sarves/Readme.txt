Configured Load-Rest in 8082 port
Configured Customer-Rest in 8083 Port
Configured Carrier-Rest in 8084 port

Eureka Server Runs in port 8081

Zuul proxy runs in port 8080

Step 1: First Start the Eureka application so that it will listen for other services to get registered.

Step 2: Run the other services Load, Customer and Carrier 

check for the registered services in eureka dashboard : localhost:8081

Step 3: Start the zuul proxy 

and access the applications using the following urls

localhost:8080/api/loads/loads
localhost:8080/api/customers/customers
localhost:8080/api/carriers/carriers

To check the hystrix dashboard 

localhost:8082/hystrix