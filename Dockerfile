FROM oracle/graalvm-ce:1.0.0-rc16 AS builder
ENV GRAALVM_HOME $JAVA_HOME
WORKDIR /workspace

COPY pom.xml mvnw ./
COPY .mvn ./.mvn/
RUN ./mvnw dependency:go-offline

COPY . .
RUN ./mvnw package -Pnative

FROM debian:stretch-slim
WORKDIR /workspace

RUN apt-get update && apt-get install -y wait-for-it \
    && rm -rf /var/lib/apt/lists/*

COPY --from=builder /workspace/target/*-runner ./application
RUN chmod 775 /workspace

ENV QUARKUS_DATASOURCE_URL "jdbc:postgresql://postgres:5432/postgres"

EXPOSE 8080
CMD ["wait-for-it", "postgres:5432", "--", "./application"]
