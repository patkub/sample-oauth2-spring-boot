FROM docker.io/gradle:8-jdk21-alpine

WORKDIR /tmp
ADD . /tmp

RUN gradle build

CMD ["gradle", "clean", "bootRun"]
EXPOSE 3001
