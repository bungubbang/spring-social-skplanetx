package org.springframework.social.skplanetx.api.user;

import org.springframework.social.skplanetx.api.impl.AbstractSkplanetxOperations;
import org.springframework.social.skplanetx.api.user.dto.SkplanetxUserProfile;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class UserTemplate extends AbstractSkplanetxOperations implements UserOperations {

    private RestTemplate restTemplate;
    private Integer version;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorized, Integer version) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
        this.version = version;
    }

    @Override
    public SkplanetxUserProfile getProfile() {
        return restTemplate.getForObject("https://apis.skplanetx.com/users/me/profile?version={version}", SkplanetxUserProfile.class, version);
    }
}