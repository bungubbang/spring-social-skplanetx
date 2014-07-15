package org.springframework.social.skplanetx.api.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.skplanetx.api.Skplanetx;
import org.springframework.social.skplanetx.api.melon.MelonOperations;
import org.springframework.social.skplanetx.api.melon.MelonTemplate;
import org.springframework.social.skplanetx.api.user.UserOperations;
import org.springframework.social.skplanetx.api.user.UserTemplate;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxTemplate extends AbstractOAuth2ApiBinding implements Skplanetx {

    private static final Integer SK_PLNAETX_VERSION = 1;

    private String appKey;
    private String accessToken;

    private UserOperations userOperations;
    private MelonOperations melonOperations;


    public SkplanetxTemplate(String appKey, String accessToken) {
        super(accessToken);
        initialize(appKey, accessToken);
    }

    @Override
    public UserOperations getUser() {
        return userOperations;
    }

    @Override
    public MelonOperations getMelon() {
        return melonOperations;
    }

    private void initialize(String appKey, String accessToken) {
        this.accessToken = accessToken;
        this.appKey = appKey;

        userOperations = new UserTemplate(getRestTemplate(), isAuthorized(), SK_PLNAETX_VERSION);
        melonOperations = new MelonTemplate(getRestTemplate(), isAuthorized(), SK_PLNAETX_VERSION);
    }

    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(getJson2MessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    protected MappingJackson2HttpMessageConverter getJson2MessageConverter() {
        Jackson2ObjectMapperFactoryBean factoryBean = new Jackson2ObjectMapperFactoryBean();
        factoryBean.setFeaturesToEnable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        factoryBean.setFeaturesToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        factoryBean.afterPropertiesSet();

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(factoryBean.getObject());

        return messageConverter;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.addAll(restTemplate.getInterceptors());
        interceptors.add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                HttpRequest protectedResourceRequest = new HttpRequestDecorator(request);
                protectedResourceRequest.getHeaders().set("appKey", appKey);
                protectedResourceRequest.getHeaders().set("access_token", accessToken);
                return execution.execute(protectedResourceRequest, body);
            }
        });

        restTemplate.setInterceptors(interceptors);
    }
}
