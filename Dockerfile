# define base docker image - openjdk:11
FROM openjdk:11

# metadata
LABEL maintainer="nadine"

# copy .jar to docker image
ADD ./target/ClassRoomSvcs-0.0.1-SNAPSHOT.jar classroomsvc.jar

# command to run when starting docker
ENTRYPOINT ["java", "-jar", "classroomsvc.jar"]

