package io.extact.mp.sample.docker_maven.server.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.extact.sample.docker_maven.server.hello.HelloResource;
import io.helidon.microprofile.tests.junit5.AddConfig;
import io.helidon.microprofile.tests.junit5.HelidonTest;

@HelidonTest
@AddConfig(key = "server.port", value = "7001")
@ExtendWith(JulToSLF4DelegateExtension.class)
public class HelloResourceTest {

    private HelloResource helloResource;

    @BeforeEach
    public void setup() throws Exception {
        helloResource = RestClientBuilder.newBuilder()
                .baseUri(new URI("http://localhost:7001/hello"))
                .build(HelloResource.class);
    }

    @Test
    void tesHello() {
        var expected = "hello!";
        var actual = helloResource.hello();
        assertEquals(expected, actual);
    }
}
