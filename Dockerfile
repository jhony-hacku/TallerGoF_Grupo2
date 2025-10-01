FROM openjdk:17
WORKDIR /app
COPY src/test/java/*.java /app/
RUN javac *.java
CMD ["java", "Main"]
