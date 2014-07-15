package org.springframework.social.skplanetx.security;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.skplanetx.api.Skplanetx;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class SkplanetxAuthenticationService extends OAuth2AuthenticationService<Skplanetx> {

    public SkplanetxAuthenticationService(OAuth2ConnectionFactory<Skplanetx> connectionFactory) {
        super(connectionFactory);
    }
}
