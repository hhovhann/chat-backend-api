#!/bin/sh
mvn clean package && java -jar ./target/chat-backend-api-1.0.0-SNAPSHOT.jar