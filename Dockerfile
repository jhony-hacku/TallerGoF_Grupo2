# build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /build
COPY src/ /build/src/
RUN find /build/src -name "*.java" > sources.txt \
 && javac -encoding UTF-8 -Xlint:unchecked -d /build/out @sources.txt

# runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/out /app/classes
ARG MAIN_CLASS
ENV MAIN_CLASS=${MAIN_CLASS}
CMD ["sh","-c","java -cp /app/classes ${MAIN_CLASS}"]
