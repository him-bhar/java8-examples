package com.himanshu.java8.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecuredHttpClientRequestSender {
  
  private static final String DEFAULT_USER = "himanshu";
  private static final String DEFAULT_PASS = "bhardwaj";
  
  private static Logger logger =  LoggerFactory.getLogger(SecuredHttpClientRequestSender.class);
  
  public static void main(String[] args) throws ClientProtocolException, IOException {
    HttpGet request = new HttpGet("http://192.168.1.48:8080/web-1.0.0-SNAPSHOT-rnull/user/api/v1/himanshu");
    //HttpGet request = new HttpGet("http://192.168.1.48:8080/web-1.0.0-SNAPSHOT-rnull/login");
    String auth = DEFAULT_USER + ":" + DEFAULT_PASS;
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
    String authHeader = "Basic " + new String(encodedAuth);
    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
     
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response = client.execute(request);
    
    InputStream is = response.getEntity().getContent();
    
    StringBuilder sb = new StringBuilder();
    byte[] b = new byte[4096];
    int n = 0;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    while ((n = is.read(b)) != -1) {
      //sb.append(n);
      baos.write(b, 0, n);
    }
    
    logger.info("Response is : - "+ new String(baos.toByteArray()));
    
    int statusCode = response.getStatusLine().getStatusCode();
    Assert.assertThat(statusCode, Matchers.equalTo(HttpStatus.SC_OK));
  }
  
  /*public static void main(String[] args) throws ClientProtocolException, IOException {
    CredentialsProvider provider = new BasicCredentialsProvider();
    UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("himanshu", "bhardwaj");
    provider.setCredentials(AuthScope.ANY, credentials);
    HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
     
    HttpResponse response = client.execute(new HttpGet("http://localhost:8080/web-1.0.0-SNAPSHOT-rnull/user/api/v1/himanshu"));
    int statusCode = response.getStatusLine().getStatusCode();
    System.out.println(statusCode);
  }*/
}
