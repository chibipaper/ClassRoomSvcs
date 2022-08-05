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
4. Run app using ```mvn clean install```

### Run Commands
```aidl
mvn spring-boot:run
mvn clean install
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