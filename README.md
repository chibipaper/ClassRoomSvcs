# ClassRoomSvcs
Template app for microservice application to be deployed on AWS ECS cluster + CI CD pipeline 

Tech Stack: MySQL, Spring-boot + Hibernate JPA, Docker, AWS ECS, AWS CloudFormation

# Goals
- [x] Basic Spring JPA CRUD post/put/get/delete
- [x] Local MySQL Connection Setup 
- [ ] App Logging FE/BE
- [ ] Generalise Exception Handling Messages
- [x] Dockerfile configuration
- [x] Environment variables + integration with CLI commands
- [ ] Setup CI CD pipeline for 1 microservice + Docker
- [ ] Proper handling of app secrets
- [ ] Windows + macOS compatability support (to test on both platforms)
- [X] RDS setup, local connection of app to RDS
- [ ] RDS setup, cloud connection of app to RDS
- [ ] RabbitMQ Local Setup
- [ ] RabbitMQ Cloud Setup
- [ ] Logging and monitoring on cloud
- [ ] Basic network configurations for ECS cluster
- [ ] Streamlining process with CloudFormation template after manual configurations have been tested

# Getting Started
## Microservice app
### Project Setup
1. Install MySQL Server, mySql Workbench, or use DBeaver or an equivalent DBMS that can run MySQL DBS
2. Alternatively, run mySQL container using docker for easy setup.
3. Create a Database 'peerTutor'
4. Run app using ```mvn clean install```, or ```mvn spring-boot:run```

## Run Commands

### Running Locally without Docker
Make sure a SQL server is running locally. Take note of the port it is listening to (usually 3306)
If SQL server is not listening on port 3306, configure it to run on port 3306.

Otherwise, check application.properties datasource field. Make sure the url is pointing to the right port and that the credentials are correct.
```aidl
spring.datasource.url=jdbc:mysql://localhost:3306/peerTutor?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=my-secret-pw
```
Then, start spring boot app with either of these commands:
```aidl
mvn spring-boot:run
mvn clean install
```

### Running Locally using Docker Compose
Launch MySql server, spring container together
```aidl
// start applications
docker-compose up
// close
docker-compose down 
```

### Running Locally but connected to AWS RDS using Docker only
```aidl
// build image
docker build . --no-cache  -t app
// run image with env variables
docker run -e "SPRING_PROFILES_ACTIVE=aws" -e "SPRING_DOCKER_PORT=8080" -e "MYSQLDB_USER=root" -e "MYSQLDB_ROOT_PASSWORD=my-secret-pw" -e "MYSQLDB_DOCKER_PORT=3306" -p 8080:8080 -e "MYSQLDB_DATABASE=peerTutor" app
```

-------
# Docker
### Docker Setting up
docker login

## Docker Commands

### Create docker image
At root folder,
```aidl
docker build -t classroomsvc:latest . 
// docker build -tag image name:tag name <where dockerfile is located>
```


### login to dockerhub using docker cli
```docker login```

### Docker-compose
```aidl
docker-compose up
docker-compose down --rmi all //clear cache
```

### View docker images
```aidl
// view docker images
docker images

// view running docker images
docker ps [OPTIONS]
```

### push to dockerhub
```docker push chibipaper/classroom:v1```

### Run docker image
```aidl
docker run -p 8081:8090 classroomsvc
// docker run -port container-port:host-port docker-image-name
```

## Cloudformation commands
```aidl
aws cloudformation create-stack --profile personal --stack-name example-deployment --template-body file://./infrastructure/ecs.yml --capabilities CAPABILITY_NAMED_IAM --parameters 'ParameterKey=SubnetID, ParameterValue=subnet-065f03498e206a52a' --region ap-southeast-1
aws cloudformation update-stack --profile personal --stack-name example-deployment --template-body file://./infrastructure/ecs.yml --capabilities CAPABILITY_NAMED_IAM --parameters 'ParameterKey=SubnetID, ParameterValue=subnet-065f03498e206a52a' --region ap-southeast-1

aws cloudformation update-stack 
-- stack-name example-deployment
-- template-body file://./infrastructure/ecs.yml
-- capabilities CAPABILITY_NAMED_IAM
-- parameters 'ParameterKey=SubnetID, ParameterValue=subnet-065f03498e206a52a'

 
```