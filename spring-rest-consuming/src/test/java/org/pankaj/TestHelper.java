package org.pankaj;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.Rule;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class TestHelper {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8089).httpsPort(8443));

}
