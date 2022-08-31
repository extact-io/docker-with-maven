package io.extact.sample.docker_maven.server.goodbye;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public interface GoodbyeResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String goodbye();
}
