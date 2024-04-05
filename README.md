# Spring boot e-commerce micro-services with spring integration using message and queue channels (without external RabbitMQ server)

This code sample is build on top of the repository sample spring boot ecommerce-spring-amqp.
It demonstrates the use of Spring Integration messaging and channel feature to setup message based order processing system for the order-service.
It uses in-memory messaging system and is not dependend on any external broker like RabbitMQ.


## Setup locally

### Setup MySQL database

* Install mysql on local MacOS - `brew install mysql`
* Start the mysql service - `brew services start mysql`
* Confirm service is running - `brew services list`
* Login to mysql and create database and tables - `mysql -u root -p`
* Use the table_schema.sql and execute the commands one by one

### Starting the micro-services

* Open three different terminals and cd to respective micro service directory (assuming you have already cloned project locally)
* Run command - `mvn clean install -DskipTests=true`
* Finally, run the service - `mvn spring-boot:run`
* Access the services from browser -
	* user-service - `http://localhost:8081/users/`
	* product-service - `http://localhost:8082/products/`
	* order-service - `http://localhost:8083/orders/`

### Testing the application

* Move to order-service folder
* Ensure the order-service is already running
* To run test, simply run command - `mvn test`
* You can switch to order-service terminal and see the order processing in action (console output)
