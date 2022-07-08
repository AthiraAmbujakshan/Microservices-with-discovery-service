# Microservices-with-discovery-service
communication between three microservices and registering them on discovery server to prevent hardcoding the urls

three microservices - movie catalog service
 movie info service
 rating data service
 
 
 MS2(movie info service)------------------------------> MS1(movie Catalog service)<---------------------------MS3(ratings data service)
 i/p:movieId                                               i/p:userId                                         i/p:userId
 o/p:moviedetails                                          o/p:movieList with details                         o/p:movieId and ratings
 
 
 service Discovery
 
 we have hardcoded urls, eg: localhost and port. hardcoding urls is a bad practise because changes require code updates,dynamic urls in the cloud etc
 
 so we have used discovery service to register all service to discovery service, so that when client makes a request for a particular service, discovery server finds the address of the service and provides to client (client side Service Discovery)
 
 we have used Eureka server - by default it runs on port 8761.
 
 after registering all service with eureka service, we consume from movie -catalog service, using annotation @ LoadBalanced
 
