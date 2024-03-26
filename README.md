# Spring boot ecommerce micro services

Sample spring boot micro services code, with below services - 

* product-service - Displays product catalogue
* user-service - List of users that can get products and place an order
* order-service - Displays the order list with user id and product id along with quantity

All these micro services fetch data from MySQL database. 
The details about tables and schema can be found in table_schema.sql

## Setup locally

### Setup MySQL database

* Install mysql on local MacOS - `brew install mysql`
* Start the mysql service - `brew services start mysql`
* Confirm service is running - `brew services list`
* Login to mysql and create database and tables - `mysql -u root -p`
* Use the table_schema.sql and execute the commands one by one

### Starting the micro services

* Open three different terminals and cd to respective micro service directory (assuming you have already cloned project locally)
* Run command - `mvn clean install`
* Finally, run the service - `mvn spring-boot:run`

