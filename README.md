## Voting system

This project is a small challenge in which I try to represent the voting system of Big Brother Brasil in a simple way.

## Technology

Here are the technologies used in this project:

* Java version 17.0.0
* Spring Boot 3.4.0
* Rabbit
* PostgreSQL
* Docker

## Dependencies

* Spring Boot Starters
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-rabbit-test(scope test)
  - spring-boot-starter-test (scope test)

## Getting Started

### Pre-requisites

- Java 17
- Maven
- Docker

### Build and Run

1. Clone the repository:
    ```bash
    git clone https://github.com/felipemelozx/challenge-bbb
    cd ./challenge-bbb
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```
3. access the docker folder and run this command
   ```bash
    docker compose up
    ```
4. Run the project:
    ```bash
    mvn spring-boot:run
    ```

5. Access the application at `http://localhost:8080/api/voto`
use the post method and send a json in the request body like
```json
{
  "id": "2",
}
```
## Features

The main features of the application are:
- Vote Processing
  - Handles the submission of votes via a RESTful API.
  - Ensures data validation and proper formatting of incoming vote payloads.

- Asynchronous Messaging with RabbitMQ
  - Utilizes RabbitMQ to process votes asynchronously, ensuring scalability and reliability.
  - Employs message queues to decouple vote producers (API) from vote processors, enabling efficient handling of high volumes of requests.
## Links

- Repository: https://github.com/felipemelozx/challenge-bbb

## Versioning

0.0.1-SNAPSHOT

## Authors

* **Felipe**

Please follow GitHub and join us! Thanks for visiting and happy coding!
