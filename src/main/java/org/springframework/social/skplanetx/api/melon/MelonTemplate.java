package org.springframework.social.skplanetx.api.melon;

import org.springframework.social.skplanetx.api.impl.AbstractSkplanetxOperations;
import org.springframework.social.skplanetx.api.melon.MelonOperations;
import org.springframework.social.skplanetx.api.melon.dto.Melon;
import org.springframework.social.skplanetx.api.user.dto.SkplanetxUserProfile;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class MelonTemplate implements MelonOperations {

    private RestTemplate restTemplate;
    private Integer version;
    private boolean isAuthorized;

    public MelonTemplate(RestTemplate restTemplate, boolean isAuthorized, Integer version) {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;
        this.version = version;
    }


    @Override
    public ChartOperation getChart() {
        return new ChartTemplate(restTemplate, isAuthorized, version);
    }

    @Override
    public NewReleasesOperation getNewReleases() {
        return new NewReleasesTemplate(restTemplate, isAuthorized, version);
    }
}
