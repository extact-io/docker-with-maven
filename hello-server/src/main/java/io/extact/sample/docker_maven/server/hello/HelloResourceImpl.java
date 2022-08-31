package io.extact.sample.docker_maven.server.hello;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("hello")
public class HelloResourceImpl implements HelloResource  {
    @Override
    public String hello() {
        return "hello!";
    }
}
