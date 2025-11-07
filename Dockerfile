FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/conjuntos-jni-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY libconjuntos_jni.so /usr/local/lib/
COPY libconjuntos.so /usr/local/lib/
RUN ldconfig /usr/local/lib
ENTRYPOINT ["java", "-Djava.library.path=/usr/local/lib", "-jar", "app.jar"]
