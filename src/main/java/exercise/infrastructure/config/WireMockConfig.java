package exercise.infrastructure.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockConfig {

    @Value("${wiremock.port}")
    private int wireMockPort;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {
        WireMockConfiguration config = WireMockConfiguration.wireMockConfig()
                .usingFilesUnderDirectory("src/main/resources")
                .port(wireMockPort);


        WireMockServer wireMockServer = new WireMockServer(config);
        return wireMockServer;
    }

}
