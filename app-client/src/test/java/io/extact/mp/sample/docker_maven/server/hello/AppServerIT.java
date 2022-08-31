package io.extact.mp.sample.docker_maven.server.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.extact.mp.sample.docker_maven.client.AppService;
import io.helidon.microprofile.tests.junit5.AddConfig;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;

/**
 * ネットワーク越しにRestClientをテストするテストクラス。
 * <pre>
 * ・実物：CDI Bean(AppService)
 * ・実物：MicroProfile RestClient(HelloServerClient/GoodbyeServerClient)
 *     ↓ HTTP
 * ・実物：hello-serverコンテナ/goodbye-serverコンテナ
 * </pre>
 */
@HelidonTest
@AddConfig(key = "server.port", value = "0") // エフェメラルポート
@AddConfig(key = "baseUrl.hello/mp-rest/url", value = "http://localhost:7001")
@AddConfig(key = "baseUrl.goodbye/mp-rest/url", value = "http://localhost:7002")
@ExtendWith(JulToSLF4DelegateExtension.class)
public class AppServerIT {

    @Inject
    private AppService service;

    @Test
    void tesHello() {
        var expected = "hello!"; // 本物は全て小文字
        var actual = service.getHello();
        assertEquals(expected, actual);
    }
}
