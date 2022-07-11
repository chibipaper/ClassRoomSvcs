# ClassRoomSvcs

## Getting Started

### Run Commands
```aidl
mvn spring-boot:run
mvn clean install
```

## Docker Commands

### Create docker image
At root folder,
```aidl
docker build -t classroomsvc:latest . 
// docker build -tag image name:tag name <where dockerfile is located>
```

### View docker images
```aidl
// view docker images
docker images

// view running docker images
docker ps [OPTIONS]
```

### Run docker image
```aidl
docker run -p 8081:8090 classroomsvc
// docker run -port container-port:host-port docker-image-name
```

## Cloudformation commands
```aidl
aws cloudformation create-stack --profile personal --stack-name example-deployment --template-body file://./infrastructure/ecs.yml --capabilities CAPABILITY_NAMED_IAM --parameters 'ParameterKey=SubnetID, ParameterValue=subnet-1881f750' --region ap-southeast-1
aws cloudformation update-stack --profile personal --stack-name example-deployment --template-body file://./infrastructure/ecs.yml --capabilities CAPABILITY_NAMED_IAM --parameters 'ParameterKey=SubnetID, ParameterValue=subnet-1881f750' --region ap-southeast-1

aws cloudformation update-stack 
-- stack-name example-deployment
-- template-body file://./infrastructure/ecs.yml
-- capabilities CAPABILITY_NAMED_IAM
-- parameters 'ParameterKey=SubnetID, ParameterValue=subnet-1881f750'

 
```