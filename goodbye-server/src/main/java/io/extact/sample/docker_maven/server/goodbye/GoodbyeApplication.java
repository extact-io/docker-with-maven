package io.extact.sample.docker_maven.server.goodbye;

import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
public class GoodbyeApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(GoodbyeResourceImpl.class);
    }
}
