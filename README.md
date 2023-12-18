# Software Document
Chat Server Rest API service project for Spring Boot

## Software Environment

- Java 21
- MongoDb database
- WebSockets
- Spring Boot 3.2.0
- Maven 3.9.5

## Software Structure
- feature_name(user) 
  - controller
  - document
  - enums
  - exception
  - repository
  - service
...

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API endpoints and Send for the User Registration, ChatMessages Topics:

1. User Registration: Add a feature for users to sign up with their email, name, password, and a unique username
2. User Login: Create a login system where users can sign in with their email and password.
3. Search for Other Users: Make a simple search tool to find other users by their usernames.
4. Chat Message: Allow users to start chatting with someone they find.
5. Show All Message History:  Save chat messages in a database. - Let users see their chat history in an easy-to-read way.


## Software Setup and Run:  Docker containers
- Create .env file from the root project with
- From root directory start containers with `docker-compose up`
- To stop the containers run `docker compose down`

## Software Setup and Run: Local Application
- Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop/) if you not have it installed in your machine
- Run local mongodb ```docker run -d --name YOUR_CONTAINER_NAME_HERE -p YOUR_LOCALHOST_PORT_HERE:27017 -e MONGO_INITDB_ROOT_USERNAME=YOUR_USERNAME_HERE -e MONGO_INITDB_ROOT_PASSWORD=YOUR_PASSWORD_HERE mongo```
- Run application with bach command from project root ./scripts/run.sh
- Run the application from the IDEA itself

## Software testing
- TODO

## Software Design and Diagram
- TODO
