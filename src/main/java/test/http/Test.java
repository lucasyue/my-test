package test.http;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		String cntNo = "TEMU0705465";
		String keyid = "5bd7661d-83a8-45fc-b43e-29aca40990d6";
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String apisign = DigestUtils.md5Hex("keyid=5bd7661d-83a8-45fc-b43e-29aca40990d6&timestamp=" + timestamp
				+ "&secretkey=00729f20-4b23-4343-ac6f-fff84e096672");
		String url = "https://ykapi.portx.cn/container/dynamic/" + cntNo;// "?keyid={keyid}&timestamp={timestamp}&apisign={apisign}";
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("keyid", keyid);
		requestHeaders.add("timestamp", timestamp);
		requestHeaders.add("apisign", apisign);
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
				.build();
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		HttpEntity<Object> requestEntity = new HttpEntity<>(null, requestHeaders);
		ResponseEntity<Map> resEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Map.class);
		Map resultMap = resEntity.getBody();
		int code = Integer.parseInt(resultMap.get("code").toString());
		if (code == 0) {
			// 成功
			List<Map<String, Object>> resultList = (List<Map<String, Object>>) resultMap.get("result");
		} else {
			String errorMsg = (String) resultMap.get("msg");
			throw new RuntimeException(errorMsg);
		}
	}
}
