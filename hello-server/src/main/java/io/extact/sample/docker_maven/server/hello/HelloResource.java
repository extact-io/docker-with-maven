package io.extact.sample.docker_maven.server.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public interface HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String hello();
}
