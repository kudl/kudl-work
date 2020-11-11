package com.kudlwork.boot.api.helper;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureWebTestClient(timeout = "10000")
public class FileCryptTest {

	@Mock
	private RestTemplate restTemplate;
	private final String KEY = "abcABCabcABCabcABCabcABCabcABCab";
	private final String PLAIN_IV = "abababababababab";
	private final String ENCODE_IV = "YWJhYmFiYWJhYmFiYWJhYg==";
	private final String IMAGE_PATH = "/image/sample.png";
	private URL SERVER_URL;

	@BeforeEach
	void setMockData() throws Exception {
		SERVER_URL = new URL("http://localhost:3000/hello");
	}

	@DisplayName("Test Base64 Encoding")
	@Test
	public void testBaseEncode() throws UnsupportedEncodingException {
		String encodeIV = new String(Base64.encodeBase64(PLAIN_IV.getBytes("UTF-8")));

		assertThat(ENCODE_IV, is(encodeIV));
	}

	@DisplayName("Test Image Crypt Request")
	@Test
	public void testImageCryptRequest() throws Exception {
		MultiValueMap<String, Object> params = mockParams();
		ResponseEntity<String> response = mockResponseEntity();
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, new HttpHeaders());

		when(restTemplate.postForEntity(SERVER_URL.toString(), requestEntity, String.class))
			.thenReturn(response);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	private ResponseEntity mockResponseEntity() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private String getImageEncrypt() throws Exception {
		ClassPathResource resource = new ClassPathResource(IMAGE_PATH);
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(PLAIN_IV.getBytes("UTF-8")));
		return new String(Base64.encodeBase64(c.doFinal(resource.getInputStream().readAllBytes())));
	}

	private MultiValueMap<String, Object> mockParams() throws Exception {
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
		params.add("img", getImageEncrypt());
		params.add("img_ext", new String(Base64.encodeBase64(PLAIN_IV.getBytes("UTF-8"))));
		return params;
	}
}
