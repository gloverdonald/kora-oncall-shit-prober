ARG JAVA_IMAGE=openjdk:17-oracle

FROM openjdk:17-oracle as build

COPY build/distributions/*.tar /opt/application.tar

RUN tar -xf /opt/application.tar -C /opt

FROM ${JAVA_IMAGE}

COPY --from=build /opt/application /opt/application
ENV CLASSPATH=/opt/application/lib/*
WORKDIR /opt/application/lib

CMD java $JAVA_OPTS org.example.AppRunner
