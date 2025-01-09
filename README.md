# Microservice of project 


## About the Project

This project is a simple microservices architecture with two microservices: a user microservice and an email microservice.
We  implement asynchronous communication between the two microservices using RabbitMQ.

## Follow the project flow
1. The microservice user(the **Producer**) send a message to RabbitMQ message broker
2. The microservice emaii(The **Consumer**) connects to exchange and receives the message in the queue.
3. The microservice emaii(The **Consumer**) then process the message and send a email to user. 

## Technologies Used
In this project, we are making use of the following technologies:
- Java
- Maven
- Spring boot
    - Spring web
    - Spring Data jpa
    - Spring Validation
    - Spring AMQP
    - Spring E-mail
- POSTGRESSQL
- RabbitMQ
- CloudAMQP
- SMTP GMAIL
- Docker/ Docker compose
