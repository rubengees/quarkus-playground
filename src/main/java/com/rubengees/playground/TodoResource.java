package com.rubengees.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    private static final Logger LOG = LoggerFactory.getLogger(TodoResource.class);

    @GET
    public List<Todo> list() {
        return TodoEntity.<TodoEntity>listAll().stream()
                .map(entity -> new Todo(entity.getName(), entity.getDescription(), entity.isDone()))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public void create(Todo todo) {
        LOG.info("Received new todo: " + todo.toString());

        new TodoEntity(todo).persist();
    }

    @DELETE
    @Transactional
    @Path("{name}")
    public Response delete(@PathParam("name") String name) {
        LOG.info("Deleting todos with name: " + name);

        if (TodoEntity.delete("name", name) <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }
}
