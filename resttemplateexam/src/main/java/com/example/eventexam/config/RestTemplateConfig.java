package com.example.eventexam.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    // RestTemplate은 내부적으로 HttpURLConnection을 사용하는데, HTTP 1.1 스펙을 모두 지키지 않는다. 그래서 Patch를지원안함.
    // RestTemplate에서 ClientHttpRequestFactory인터페이스 구현체를 사용해야 한다.
    // 스프링은 OkHttp3Client를 지원해준다. OkHttp3Client의존성을 build.gradle에는 넣어줘야함.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}