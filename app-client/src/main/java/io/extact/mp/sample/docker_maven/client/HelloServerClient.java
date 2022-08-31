package io.extact.mp.sample.docker_maven.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "baseUrl.hello")
@Path("hello")
public interface HelloServerClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String hello();
}
