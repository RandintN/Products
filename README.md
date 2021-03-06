Application for a tech challenge

**Used technologies**

* Java 8
* Spring Boot 2
* Spring Data MongoDB
* Spring Security
* MongoDB
* Swagger
* Docker
* Docker Compose

**Quick Start Guide**

1. Have docker installed, [click here](https://docs.docker.com/get-docker/) for installation instructions
2. Install docker-compose, [click here](https://docs.docker.com/compose/install/) for instructions
3. Go to the folder where this `README.md` file is located alongside `Dockerfile` and `docker-compose.yml`
4. Input the following command on a terminal:
`docker-compose up`
5. Wait for docker to run it's pulling of images
6. Go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to see and use the 
available endpoint's resources. 

**Without Docker**

To run the application locally without docker, it's necessary to have a running MongoDB server 
and to add the following program arguments on your IDE of choice: `--spring.data.mongodb.host=localhost`

At the root of the project, where this README.md file is, run:  `maven clean install`  or, if you don't have maven installed, 
run:  `chmod +x mvnw && ./mvnw clean  install -Dspring.data.mongodb.host=localhost`

After successful build, run: `java -jar target/products-0.0.1-SNAPSHOT.jar --spring.data.mongodb.host=localhost`

The application will be available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
