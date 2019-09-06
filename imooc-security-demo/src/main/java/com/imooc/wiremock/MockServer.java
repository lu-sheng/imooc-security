package com.imooc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * LN
 * 2019/9/6 0006 10:29
 */
public class MockServer {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8081);
        WireMock.removeAllMappings();
        mock("/user/1", "01");

    }

    private static void mock(String url, String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock.response/" + fileName + ".txt");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url)).willReturn(
                WireMock.aResponse().withBody(content).withStatus(200)
        ));
    }
}
