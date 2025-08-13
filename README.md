# Kafka
Basics Commands
  1. C:\kafka>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
  2. C:\kafka>bin\windows\kafka-server-start.bat config\server.properties
  3. C:\kafka>bin\windows\kafka-console-consumer.bat --topic kafkaTopic1 --from-beginning --bootstrap-server localhost:9092
  4. C:\kafka>bin\windows\kafka-console-consumer.bat --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:9092
  5. curl --location 'http://localhost:8080/api/v1/kafka/publish?message=test%20kafka%20message'
  6. curl --location 'http://localhost:8080/api/v1/kafka/publish' \
    --header 'Content-Type: application/json' \
    --data '{
        "id":1,
        "firstName":"Dheeraj",
        "lastName":"Kumar"
    }'
  
  7. https://stream.wikimedia.org/v2/stream/recentchange

# chat-gpt
1. curl --location 'http://localhost:8080/api/chat/ask?prompt=Tell%20me%20a%20joke'
2. curl --location 'localhost:8080/api/chat' \
--header 'Content-Type: text/plain' \
--data 'Explain Spring Boot in simple terms.'
3. curl --location 'localhost:8080/post' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data '{
    "name": "abc",
    "category": "abc",
    "price": 191.0
}'

# spring-boot-docker
  This project demonstrates how to containerize a Spring Boot application using Docker and perform basic CRUD operations through REST APIs.

---

## 🛠 Prerequisites
- Java 17+
- Maven
- Docker

---

## 📦 Build the Docker Image

### Build with version tag:
- docker build -t spring-boot-docker:1.0 .

## Run the container
- detached mode: docker run -d -p 8080:8080 spring-boot-docker:1.0
- foreground mode: docker run -p 8080:8080 spring-boot-docker:1.0

## Build & Run
- docker build -t spring-boot-docker.jar .
- docker run -p 9090:8080 spring-boot-docker.jar

## Managing Containers
- docker start <CONTAINER_ID>
- docker stop <CONTAINER_ID>

##
🌐 API Endpoints
- Create Employee
curl --location 'http://localhost:8080/employees' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Dheeraj Kumar",
    "salary": 98000,
    "department": "Senior Specialist - Software Engineer"
}'
- Get All Employees
curl --location 'http://localhost:8080/employees'
- Update Employee by ID
curl --location --request PUT 'http://localhost:8080/employees/111' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Dheeraj Kumar",
    "salary": 99000,
    "department": "Senior Specialist - Software Engineer"
}'
- Delete Employee by ID
curl --location --request DELETE 'http://localhost:8080/employees/111'
- Get Employee by ID
curl --location 'http://localhost:8080/employees/111'
