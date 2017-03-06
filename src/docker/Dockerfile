FROM java:8
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar photo_micro_service.jar
EXPOSE 8094
RUN sh -c 'touch /photo_micro_service.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /photo_micro_service.jar" ]
