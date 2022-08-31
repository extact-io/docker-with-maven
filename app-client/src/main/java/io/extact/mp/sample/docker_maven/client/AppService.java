package io.extact.mp.sample.docker_maven.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppService {
    private HelloServerClient helloClient;
    private GoodbyeServerClient goodbyeClient;

    @Inject
    public AppService(@RestClient HelloServerClient helloClient, @RestClient GoodbyeServerClient goodbyeClient) {
        this.helloClient = helloClient;
        this.goodbyeClient = goodbyeClient;
    }

    public String getHello() {
        return helloClient.hello();
    }

    public String getGoodbye() {
        return goodbyeClient.goodbye();
    }
}
