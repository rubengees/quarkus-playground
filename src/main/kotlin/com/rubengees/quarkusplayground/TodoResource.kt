package com.rubengees.quarkusplayground

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TodoResource {

    @GET
    fun todos(): List<Todo> {
        return listOf(
            Todo(1, "Hello", "Graal", true),
            Todo(2, "Hi", "Quarkus", false)
        )
    }
}
