FROM java:8
VOLUME /tmp
ADD target/mongo-geo-spatial-search-0.0.1-SNAPSHOT.jar mongo-geo-spatial-search.jar
EXPOSE 8080
RUN bash -c 'touch /mongo-geo-spatial-search.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/micros", "-Djava.security.egd=file:/dev/./urandom","-jar","/mongo-geo-spatial-search.jar"]