package com.imgur.vendors.cloudsight_client;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class TestCSApi {

  private static final String API_KEY = "XXX";

  static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  static final JsonFactory JSON_FACTORY = new JacksonFactory();



  public static void main(String[] args) throws Exception {
    CSApi api = new CSApi(
      HTTP_TRANSPORT,
      JSON_FACTORY,
      API_KEY
    );
    CSPostConfig imageToPost = CSPostConfig.newBuilder()
      .withRemoteImageUrl("http://i.imgur.com/xHGpFRL.gif")
      .build();

    CSPostResult portResult = api.postImage(imageToPost);

    System.out.println("Post result: " + portResult);

    Thread.sleep(30000);

    CSGetResult scoredResult = api.getImage(portResult);

    System.out.println(scoredResult);
  }
}