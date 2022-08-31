package io.extact.mp.sample.docker_maven.server.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.extact.mp.sample.docker_maven.client.AppService;
import io.extact.mp.sample.docker_maven.client.GoodbyeServerClient;
import io.extact.mp.sample.docker_maven.client.HelloServerClient;
import io.extact.mp.sample.docker_maven.server.hello.AppServerTest.HelloServerClientStub;
import io.extact.mp.sample.docker_maven.server.hello.AppServerTest.StubApplication;
import io.helidon.microprofile.tests.junit5.AddBean;
import io.helidon.microprofile.tests.junit5.AddConfig;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;

/**
 * ネットワーク越しにRestClientをテストするテストクラス。
 * <pre>
 * ・実物：CDI Bean(AppService)
 * ・実物：MicroProfile RestClient(HelloServerClient/GoodbyeServerClient)
 *     ↓ HTTP
 * ・スタブ：JAX-RS REST Resource(HelloServerClientStub/GoodbyeServerClientStub)
 * </pre>
 */
@Disabled
@HelidonTest
@AddConfig(key = "server.port", value = "7001")
@AddConfig(key = "baseUrl.hello/mp-rest/url", value = "http://localhost:7001")
@AddConfig(key = "baseUrl.goodbye/mp-rest/url", value = "http://localhost:7001")
@AddBean(HelloServerClientStub.class)
@AddBean(StubApplication.class)
@ExtendWith(JulToSLF4DelegateExtension.class)
public class AppServerTest {

    @Inject
    private AppService service;

    @Test
    void tesHello() {
        var expected = "Hello!";
        var actual = service.getHello();
        assertEquals(expected, actual);
    }

    @Test
    void tesGoodbye() {
        var expected = "Good-bye!";
        var actual = service.getGoodbye();
        assertEquals(expected, actual);
    }


    // ---------------------------------------- REST Resource Stub

    @Path("hello")
    static class HelloServerClientStub implements HelloServerClient {
        @Override
        public String hello() {
            return "Hello!";
        }
    }

    @Path("goodbye")
    static class GoodbyeServerClientStub implements GoodbyeServerClient {
        @Override
        public String goodbye() {
            return "Good-bye!";
        }
    }

    static class StubApplication extends Application {
        @Override
        public Set<Class<?>> getClasses() {
            return Set.of(
                    HelloServerClientStub.class,
                    GoodbyeServerClientStub.class);
        }
    }
}
