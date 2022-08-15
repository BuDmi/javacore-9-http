package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static String REMOTE_SERVICE_URL =
        "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(30000)
                .setRedirectsEnabled(false)
                .build())
            .build()
        ) {

            HttpGet request = new HttpGet(REMOTE_SERVICE_URL);

            try(CloseableHttpResponse response = httpClient.execute(request)) {

                List<CatFact> posts = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});

                List<CatFact> filteredPosts =
                    posts.stream().filter(post -> post.getUpvotes() != null).collect(Collectors.toList());
                filteredPosts.forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
