package org.springframework.social.skplanetx.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
public class AbstractSkplanetxOperations {

    private final boolean isAuthorized;

    private static final String API_HOST = "http://apis.skplanetx.com";

    public AbstractSkplanetxOperations(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("skplanetx");
        }
    }
}
