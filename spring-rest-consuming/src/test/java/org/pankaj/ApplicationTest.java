/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pankaj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pankaj.model.GreetingResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    RestTemplate restTemplate;
    ResponseEntity response;

    String realServer="http://localhost:8998/greeting";

    @ClassRule
    public static WireMockClassRule wiremock = new WireMockClassRule(
            WireMockSpring.options().port(8999));

    @Before
    public void setup() throws Exception {
        restTemplate = new RestTemplate();
        response = null;
    }

    @Test
    public void givenWireMockEndpoint_whenGetWithoutParams_thenVerifyRequest() throws JsonProcessingException {
        stubFor(get(urlEqualTo("/greeting/user/greet"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody(getBody())));

        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8999/greeting/user/greet", GreetingResponse.class);
        assertEquals(200,responseEntity.getStatusCodeValue());
        System.out.println("responseEntity = " + responseEntity.getBody());

//            assertThat("Verify Response Body", response.getBody().contains("test"));
//            assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

      //  verify(getRequestedFor(urlMatching("/api/resource/.*")));
    }

    private String getBody() throws JsonProcessingException {
        return "{\"id\":5,\"content\":\"Hello, World!\"}";
    }


}
