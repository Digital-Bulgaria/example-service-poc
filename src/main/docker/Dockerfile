FROM anapsix/alpine-java:8
VOLUME /tmp
ADD maven/${docker.build.finalName}.jar  ${docker.build.finalName}.jar
RUN bash -c 'touch /${docker.build.finalName}.jar'
EXPOSE ${service.port}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/${docker.build.finalName}.jar"]
 