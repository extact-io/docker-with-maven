package io.extact.sample.docker_maven.server.goodbye;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("goodbye")
public class GoodbyeResourceImpl implements GoodbyeResource  {
    @Override
    public String goodbye() {
        return "good-bye!";
    }
}
