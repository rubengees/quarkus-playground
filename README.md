# Quarkus Playground

This is a simple playground for [Quarkus](quarkus.io).

It exposes a `/todos` API on `localhost:8080`:

```sh
$ curl -X POST http://localhost:8080/todos \
    -d '{
      "name": "orm",
      "description": "abc",
      "done": true
     }'

$ curl -X GET http://localhost:8080/todos
[{"description":"abc","done":true,"name":"orm"}]

$ 
```