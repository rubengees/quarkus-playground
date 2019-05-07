# Quarkus Playground

This is a simple playground for [Quarkus](https://quarkus.io).

It exposes a `/todos` API on `localhost:8080`:

```bash
$ curl -X POST http://localhost:8080/todos \
    -H 'Content-Type: application/json' \
    -d '{
      "name": "orm",
      "description": "abc",
      "done": true
     }'

$ curl -X GET http://localhost:8080/todos
[{"description":"abc","done":true,"name":"orm"}]
```

### Prerequisites

- GraalVM Java
- PostgreSQL running on port `5432`
  - Run the following to quickly create on with docker: `docker run --rm --name todo-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres`

### Starting

The application can be started with `./mvnw compile quarkus:dev`. This command also feature live reload;
If you do a change, the code is automatically recompiled at the next request.

To build a native image, run `./mvnw package -Pnative`. This creates a native executable for your OS and can be found
in the `target` folder.

```bash
$ ./target/quarkus-playground-0.0.1-runner
```

### Docker

This repository also comes with scripts to build and run a docker container (using the native executable):

```bash
$ ./build-docker.sh
$ ./run-docker.sh
```
