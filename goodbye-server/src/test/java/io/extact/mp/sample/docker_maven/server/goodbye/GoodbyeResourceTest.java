package io.extact.mp.sample.docker_maven.server.goodbye;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.extact.sample.docker_maven.server.goodbye.GoodbyeResource;
import io.helidon.microprofile.tests.junit5.AddConfig;
import io.helidon.microprofile.tests.junit5.HelidonTest;

@HelidonTest
@AddConfig(key = "server.port", value = "7002")
@ExtendWith(JulToSLF4DelegateExtension.class)
public class GoodbyeResourceTest {

    private GoodbyeResource goodbyeResource;

    @BeforeEach
    public void setup() throws Exception {
        goodbyeResource = RestClientBuilder.newBuilder()
                .baseUri(new URI("http://localhost:7002/goodbye"))
                .build(GoodbyeResource.class);
    }

    @Test
    void tesHello() {
        var expected = "good-bye!";
        var actual = goodbyeResource.goodbye();
        assertEquals(expected, actual);
    }
}
