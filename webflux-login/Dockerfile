# WebFlux version needs full image
FROM docker.io/gradle:9.2.1-jdk21

WORKDIR /tmp
ADD . /tmp

RUN gradle build

CMD ["gradle", "clean", "bootRun"]
EXPOSE 3001
