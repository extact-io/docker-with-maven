package io.extact.mp.sample.docker_maven.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "baseUrl.goodbye")
@Path("goodbye")
public interface GoodbyeServerClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String goodbye();
}
